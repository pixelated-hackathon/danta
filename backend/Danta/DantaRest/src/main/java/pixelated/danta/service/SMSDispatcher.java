/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public boolean pushSMS(String phone, String content) {
        boolean result = true;
        try {
            BoSMSLog newSMS = new BoSMSLog();
            newSMS.setContent(content);
            newSMS.setPhoneNumber(phone);
            smsDao.saveLog(newSMS);

            String[] contentParts = content.split(" ");
            if (contentParts.length == 0) {
                throw new DaoMessageException("El mensaje debe de contener espacios");
            }

            if (contentParts[0].toUpperCase().equals(PAYMENT_PREFIX)) {
                if (contentParts.length > 3) {
                    String commerceNumber = contentParts[1];
                    try {
                        Double amount = Double.parseDouble(contentParts[2]);
                        result = familyPaymentLogicController.doPayment(phone, commerceNumber, amount);
                    } catch (NumberFormatException ex) {
                        throw new DaoMessageException("El monto a pagar no es un número correcto");
                    }
                } else {
                    throw new DaoMessageException("El mensaje para pago debe de contener tres palabra, Pago + número de teléfono del comercio + monto a pagar");
                }

            } else {
                throw new DaoMessageException("Primera palabra no permitida");
            }
        } catch (Exception ex) {
            errorHandler.handleSMSError(this.getClass(), phone, ex);
            result = false;
        }
        return result;
    }

    public boolean pushToQueueSMS(String phone, String content) {
        boolean result = true;
        try {
            BoPendingSMS newSMS = new BoPendingSMS();
            newSMS.setContent(content);
            newSMS.setPhoneNumber(phone);
            smsDao.savePending(newSMS);
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
