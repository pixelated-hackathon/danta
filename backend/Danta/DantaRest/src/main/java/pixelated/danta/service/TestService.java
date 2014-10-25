/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pixelated.dantagae.bo.TestValue;
import pixelated.danta.dao.TestDao;
import pixelated.danta.dao.exception.DaoException;

/**
 *
 * @author Juan Carlos Rojas
 */
@Service
public class TestService {

    @Autowired
    TestDao testDao;

    public boolean storeValue(String value) {

        try {
            TestValue newTestValue = new TestValue(value);
            testDao.save(newTestValue);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public List<TestValue> getAllValues() throws DaoException {
        return testDao.getAll();
    }

    public boolean updateValue(String id, String value) {

        try {
            TestValue newTestValue = new TestValue(value);
            testDao.save(newTestValue);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
