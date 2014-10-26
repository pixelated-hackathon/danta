/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.dantagae.dao.datastore;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.Datasource;
import pixelated.danta.dao.ParamBuilder;
import pixelated.danta.dao.exception.DaoException;
import pixelated.danta.dao.exception.DaoNotFoundException;
import pixelated.danta.dao.exception.DaoRequiredFieldException;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.dantagae.bo.DaoEntity;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class Datastore implements Datasource {

    private final String ID_FIELD = "Id";
    private final DatastoreService datastore;

    public Datastore() {
        datastore = DatastoreServiceFactory.getDatastoreService();
    }

    @Override
    public DaoEntity saveEntity(DaoEntity entity) throws DaoUnexpectedException {
        try {
            Entity newEntity = getGaeEntity(entity);
            Key key = datastore.put(newEntity);
            entity.setId(KeyFactory.keyToString(key));
            return entity;
        } catch (Exception ex) {
            throw new DaoUnexpectedException(ex);
        }
    }

    @Override
    public void updateEntity(DaoEntity entity) throws DaoUnexpectedException, DaoRequiredFieldException, DaoNotFoundException {
        if (entity.getId() == null) {
            throw new DaoRequiredFieldException(entity.getClass(), ID_FIELD);
        }
        this.saveEntity(entity);
    }

    @Override
    public <T extends DaoEntity> T findById(Class<T> entityClass, String id) throws DaoUnexpectedException, DaoNotFoundException {
        try {
            Key objectId = KeyFactory.stringToKey(id);
            Entity entity = datastore.get(objectId);
            return this.getDaoEntity(entityClass, entity);
        } catch (EntityNotFoundException ex) {
            throw new DaoNotFoundException(entityClass, ID_FIELD, id);
        } catch (Exception ex) {
            throw new DaoUnexpectedException(ex);
        }
    }

    @Override
    public <T extends DaoEntity> List<T> getAll(Class<T> entityClass) throws DaoUnexpectedException {
        try {
            List<T> result = new ArrayList<T>();

            com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query(entityClass.getSimpleName());
            // Use PreparedQuery interface to retrieve results
            PreparedQuery pq = datastore.prepare(q);
            for (Entity entity : pq.asIterable()) {
                result.add(this.getDaoEntity(entityClass, entity));
            }
            return result;
        } catch (Exception ex) {
            throw new DaoUnexpectedException(ex);
        }
    }

    protected <T extends DaoEntity> Map<String, Field> getEntityFields(Class<T> entity) {
        Map<String, Field> returnFields = new HashMap<String, Field>();
        Field[] fields = entity.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            returnFields.put(field.getName(), field);
        }
        return returnFields;
    }

    protected Entity getGaeEntity(DaoEntity entity) throws DaoUnexpectedException {
        try {

            Key existingKey = null;
            if (entity.getId() != null && entity.getId().length() > 0) {
                existingKey = KeyFactory.stringToKey(entity.getId());
            }
            Entity newEntity;
            if (existingKey != null) {
                newEntity = new Entity(existingKey);
            } else {
                newEntity = new Entity(entity.getClass().getSimpleName());
            }
            Map<String, Field> fields = getEntityFields(entity.getClass());
            for (Field field : fields.values()) {
                Object fieldValue = field.get(entity);
                if (!field.getName().equals(ID_FIELD)) {
                    newEntity.setProperty(field.getName(), fieldValue);
                }
            }
            return newEntity;
        } catch (Exception ex) {
            throw new DaoUnexpectedException(ex);
        }
    }

    protected <T extends DaoEntity> T getDaoEntity(Class<T> entityClass, Entity entity) throws DaoUnexpectedException {
        try {
            Map<String, Object> values = entity.getProperties();
            T newEntity = entityClass.newInstance();
            Map<String, Field> entityFields = getEntityFields(entityClass);
            for (String field : values.keySet()) {
                if (entityFields.containsKey(field)) {
                    Field entityField = entityFields.get(field);
                    entityField.setAccessible(true);
                    entityField.set(newEntity, values.get(field));
                }
            }
            if (newEntity.getId() == null && entity.getKey() != null) {
                newEntity.setId(KeyFactory.keyToString(entity.getKey()));
            }
            return newEntity;

        } catch (Exception ex) {
            throw new DaoUnexpectedException(ex);
        }
    }

    @Override
    public <T extends DaoEntity> long drop(Class<T> entityClass) {
      
        com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query(entityClass.getSimpleName()).setKeysOnly();

        // Use PreparedQuery interface to retrieve results
        PreparedQuery pq = datastore.prepare(q);
        List<Key> keys = new ArrayList<Key>();
        for (Entity entity : pq.asIterable()) {
            keys.add(entity.getKey());
        }
        if (keys.size() > 0) {
            datastore.delete(keys.toArray(new Key[keys.size()]));
        }
        return keys.size();
    }

    
    @Override
    public <T extends DaoEntity> List<T> findByFields(Class<T> entityClass, ParamBuilder values, boolean validate) throws DaoUnexpectedException, DaoNotFoundException {
           List<T> results = new ArrayList<>();
        com.google.appengine.api.datastore.Query q = new com.google.appengine.api.datastore.Query( entityClass.getSimpleName() );
        if (values.size() > 0) {
            q.setFilter( this.toDatastoreFilter(values) );
        }
        PreparedQuery pq = datastore.prepare(q);
        for (Entity entity : pq.asIterable()) {
            results.add( this.getDaoEntity(entityClass, entity));
        }
        return results;
    }

    @Override
    public <T extends DaoEntity> T findByField(Class<T> entityClass, String field, Object value, boolean validate) throws DaoUnexpectedException, DaoNotFoundException {
       List<T> results = this.findByFields(entityClass, ParamBuilder.param(field, value),validate);
       if (results.isEmpty()) {
           return null;
       } else{
           return results.get(0);
       }
    }
    
    
    protected Query.Filter toDatastoreFilter(ParamBuilder fields) {
        Query.Filter rootFilter;
        if (fields.size() == 1) {
            String fieldName = fields.getParams().keySet().toArray()[0].toString();
            Object value = fields.getParams().get(fieldName);
            rootFilter = new Query.FilterPredicate(fieldName, com.google.appengine.api.datastore.Query.FilterOperator.EQUAL, value);
        } else {
            List<Query.Filter> filters = new ArrayList<>();
            for (String fieldName : fields.getParams().keySet()) {
                Object value = fields.getParams().get(fieldName);
                filters.add(new Query.FilterPredicate(fieldName, com.google.appengine.api.datastore.Query.FilterOperator.EQUAL, value));
            }
            rootFilter = Query.CompositeFilterOperator.and(filters);
        }
        return rootFilter;
    }
    
}


