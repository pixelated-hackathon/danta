/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.dao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.exception.DaoException;
import pixelated.danta.dao.exception.DaoRequiredFieldException;
import pixelated.dantagae.sms.BoPendingSMS;
import pixelated.dantagae.sms.BoSMSLog;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class SMSDao {

    @Autowired
    Datasource datasource;

    public BoSMSLog saveLog(BoSMSLog value) throws DaoException {
        value.setCreateDate(new Date());
        return datasource.saveEntity(value);

    }
    
    public BoPendingSMS savePending(BoPendingSMS value) throws DaoException {
        return datasource.saveEntity(value);

    }

    public List<BoPendingSMS> getAllPendings() throws DaoException {
        return datasource.getAll(BoPendingSMS.class);
    }

    public void deletePending(BoPendingSMS sms) throws DaoRequiredFieldException {
        datasource.delete(sms);
    }

}
