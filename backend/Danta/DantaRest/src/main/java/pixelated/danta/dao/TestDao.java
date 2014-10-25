/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.exception.DaoException;
import pixelated.dantagae.bo.TestValue;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class TestDao {

    @Autowired
    EntityDao entityDao;

    public TestValue save(TestValue value) throws DaoException {
        return entityDao.saveEntity(value);

    }

    public List<TestValue> getAll() throws DaoException {
        return entityDao.getAll(TestValue.class);

    }

}
