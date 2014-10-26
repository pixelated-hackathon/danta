/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pixelated.danta.dao.CommerceDao;
import pixelated.danta.dao.SMSDao;
import pixelated.danta.dao.exception.DaoException;
import pixelated.danta.dao.exception.DaoMessageException;
import pixelated.danta.service.logic.ErrorHandler;
import pixelated.dantagae.sms.BoPendingSMS;
import pixelated.dantagae.sms.BoSMSLog;

/**
 *
 * @author Juan Carlos Rojas
 */
@Service
public class SMSDispatcher {

    private final String PAYMENT_PREFIX = "Pago";

    @Autowired
    SMSDao smsDao;
    @Autowired
    FamilyPaymentLogicController familyPaymentLogicController;
    
    @Autowired
    ErrorHandler errorHandler;

    public boolean pushSMS(String phone, String content) throws DaoException {
        boolean result = false;
        try {
            BoSMSLog newSMS = new BoSMSLog();
            newSMS.setContent(content);
            newSMS.setPhoneNumber(phone);
            smsDao.saveLog(newSMS);
            
            String[] contentParts = content.split(" ");
            if (contentParts.length == 0) {
                throw new DaoMessageException("El mensaje debe de contener espacios");
            }
            
            if (contentParts[1].toUpperCase().equals( PAYMENT_PREFIX )) {
                
            }
            
            
            
            
            result = true;
        } catch (Exception ex) { 
            errorHandler.handleSMSError(this.getClass(), phone, ex);
            result = false;
        }
        return result;
    }

    public List<BoPendingSMS> pullSMS() throws DaoException {
        return smsDao.getAllPendings();
    }

}
