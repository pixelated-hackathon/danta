/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service.logic;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.SMSDao;
import pixelated.danta.dao.exception.DaoMessageException;
import pixelated.dantagae.sms.BoPendingSMS;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class ErrorHandler {

    @Autowired
    SMSDao smsDao;
    public static void handleError(Class sourceClass,  Exception ex) {
        Logger.getLogger(sourceClass.getSimpleName()).log(Level.SEVERE, null, ex);
    }
    public void handleSMSError(Class sourceClass,  String sourcePhoneNumber, Exception ex) {
        
        String additionalMessage= null;
        if (ex instanceof DaoMessageException) {
            additionalMessage =  ex.getMessage();
        }
        Logger.getLogger(sourceClass.getSimpleName()).log(Level.SEVERE, additionalMessage, ex);
        try {

            BoPendingSMS pendingSMS = new BoPendingSMS();
            pendingSMS.setPhoneNumber(sourcePhoneNumber);
            if (additionalMessage == null) {
                pendingSMS.setContent("Se encontró un problema, intente de nuevo más tarde");
            } else {
                pendingSMS.setContent("Se encontró un problema en la transacción: " + additionalMessage);
            }
            smsDao.savePending(pendingSMS);

        } catch (Exception e) {
            Logger.getLogger(sourceClass.getSimpleName()).log(Level.SEVERE, null, ex);
        }
    }

}
