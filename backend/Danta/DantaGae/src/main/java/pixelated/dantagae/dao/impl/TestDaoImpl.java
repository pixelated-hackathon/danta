/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.dantagae.dao.impl;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.TestDao;
import pixelated.dantagae.bo.TestValue;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class TestDaoImpl implements TestDao {

    public TestValue save(TestValue value) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        try {
            Entity newEntity = new Entity(TestValue.class.getSimpleName());
            newEntity.setProperty("value", value.getValue());
            newEntity.setProperty("date", value.getDate());
            Key key = datastore.put(newEntity);
            value.setId(KeyFactory.keyToString(key));
            return value;
        } finally {
            // close
        }

    }

}
