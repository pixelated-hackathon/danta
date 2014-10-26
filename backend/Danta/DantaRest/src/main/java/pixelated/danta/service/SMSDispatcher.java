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

    private final String FAMILY_PAYMENT_PREFIX = "Pago";
    private final String FAMILY_FUNDS = "Saldo";
    private final String FAMILY_TRANSACTIONS = "Cuenta";
    private final String FAMILY_REGISTER = "Registrarse";
    @Autowired
    SMSDao smsDao;

    @Autowired
    FamilyPaymentService familyPaymentLogicController;
    @Autowired
    FamilyInformationService familyInformationService;

    @Autowired
    TestService testService;

    @Autowired
    ErrorHandler errorHandler;

    public boolean pushSMS(String phone, String content) {
        boolean result = true;
        try {
            phone = formatPhone(phone);

            BoSMSLog newSMS = new BoSMSLog();
            newSMS.setContent(content);
            newSMS.setPhoneNumber(phone);
            smsDao.saveLog(newSMS);

            String[] contentParts = content.split(" ");

            if (contentParts[0].toUpperCase().equals(FAMILY_PAYMENT_PREFIX.toUpperCase())) {
                if (contentParts.length >= 3) {
                    String commerceNumber = contentParts[1];
                    try {
                        Double amount = Double.parseDouble(contentParts[2]);
                        result = familyPaymentLogicController.doPayment(phone, commerceNumber, amount);
                    } catch (NumberFormatException ex) {
                        throw new DaoMessageException("El monto a pagar no es un número correcto");
                    }
                } else {
                    throw new DaoMessageException("El mensaje para pago debe de contener tres palabras, Pago + número de teléfono del comercio + monto a pagar");
                }

            } else if (contentParts[0].toUpperCase().equals(FAMILY_FUNDS.toUpperCase())) {
                result = familyPaymentLogicController.notifyFundsToFamily(phone);
            } else if (contentParts[0].toUpperCase().equals(FAMILY_TRANSACTIONS.toUpperCase())) {
                result = familyPaymentLogicController.notifyTransactions(phone);
            } else if (contentParts[0].toUpperCase().equals(FAMILY_REGISTER.toUpperCase())) {

                if (contentParts.length >= 3) {
                    String firstName = contentParts[1];
                    String lastName = contentParts[2];
                    testService.registerFamily(phone, firstName, lastName);
                    result = true;
                } else {
                    throw new DaoMessageException("El mensaje para registrar debe de contener tres palabras, Registrar + nombre + apellido");
                }

            } else {
                throw new DaoMessageException("Mensaje no reconocido");
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
            phone = formatPhone(phone);
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

    public BoPendingSMS pullSMS() throws DaoException {
        List<BoPendingSMS> pendingSMSList = smsDao.getAllPendings();
        if (pendingSMSList.isEmpty()) {
            return new BoPendingSMS();
        } else {
            smsDao.deletePending(pendingSMSList.get(0));
            return pendingSMSList.get(0);
        }
    }

    public String formatPhone(String phone) {
        if (phone.charAt(0) == '+') {
            phone = phone.substring(4, phone.length());
        }
        return phone;
    }
}
