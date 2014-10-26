/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service;

import com.google.appengine.api.search.DateUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.CommerceDao;
import pixelated.danta.dao.FamilyDao;
import pixelated.danta.dao.GlobalDao;
import pixelated.danta.dao.SMSDao;
import pixelated.danta.dao.utils.DateUtils;
import pixelated.danta.service.logic.ErrorHandler;
import pixelated.dantagae.bo.commerce.BoCommerce;
import pixelated.dantagae.bo.family.BoFamily;
import pixelated.dantagae.bo.family.BoFamilyTransaction;
import pixelated.dantagae.bo.global.BoCurrency;
import pixelated.dantagae.sms.BoPendingSMS;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class FamilyPaymentService {

    @Autowired
    ErrorHandler errorHandler;

    @Autowired
    CommerceDao commerceDao;
    @Autowired
    FamilyDao familyDao;
    @Autowired
    SMSDao smsDao;
    @Autowired
    GlobalDao globalDao;

    private final String ADD_FOUNDS_DESCRIPTION = "Depósito de IMAS";
    private final String PAYMENT_DESCRIPTION = "Pago a comercio";

    public boolean doPayment(String familyPhone, String commercePhone, Double amount) {
        try {
            BoFamily family = familyDao.getByPhone(familyPhone,true);
            BoCommerce commerce = commerceDao.getByPhone(commercePhone);
            BoCurrency currency = globalDao.getDefaultCurreny();

            BoFamilyTransaction newFamilyTransaction = new BoFamilyTransaction();
            newFamilyTransaction.setCommerceId(commerce.getId());
            newFamilyTransaction.setCommerceDescription(commerce.getName());
            newFamilyTransaction.setFamilyId(family.getId());
            newFamilyTransaction.setFamilyDescription(family.getFamilyLastName());
            newFamilyTransaction.setAmount(amount * -1);
            newFamilyTransaction.setCurrencyCode(currency.getCode());
            newFamilyTransaction.setCurrencyDescription(currency.getDescription());
            newFamilyTransaction.setDescription(PAYMENT_DESCRIPTION);
            familyDao.saveTransaction(newFamilyTransaction);

            family.setFunds(family.getFunds() - amount);

            familyDao.update(family);

            BoPendingSMS pendingSMS = new BoPendingSMS();
            pendingSMS.setPhoneNumber(commercePhone);
            pendingSMS.setContent("Se le confirma el pago de la familia " + family.getFamilyLastName() + " por " + (newFamilyTransaction.getAmount() * -1) + " " + newFamilyTransaction.getCurrencyDescription());
            smsDao.savePending(pendingSMS);

            return true;
        } catch (Exception ex) {
            errorHandler.handleSMSError(this.getClass(), familyPhone, ex);
            return false;
        }
    }
    
    public BoFamily addFunds(String familyId, Double amount) {

        try {
            BoFamily family = familyDao.getById(familyId);
            BoCurrency currency = globalDao.getDefaultCurreny();

            BoFamilyTransaction newFamilyTransaction = new BoFamilyTransaction();
            newFamilyTransaction.setFamilyId(family.getId());
            newFamilyTransaction.setFamilyDescription(family.getFamilyLastName());
            newFamilyTransaction.setAmount(amount);
            newFamilyTransaction.setCurrencyCode(currency.getCode());
            newFamilyTransaction.setCurrencyDescription(currency.getDescription());
            newFamilyTransaction.setDescription(ADD_FOUNDS_DESCRIPTION);
            familyDao.saveTransaction(newFamilyTransaction);

            family.setFunds(family.getFunds() + amount);

            familyDao.update(family);
            return family;

        } catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);
            return null;
        }
    }

    public boolean notifyFundsToFamily(String familyPhone) {
        try {
            BoCurrency currency = globalDao.getDefaultCurreny();
            BoFamily family = familyDao.getByPhone(familyPhone,true);

            BoPendingSMS pendingSMS = new BoPendingSMS();
            pendingSMS.setPhoneNumber(familyPhone);
            pendingSMS.setContent("Su familia dispone " + family.getFunds() + " " + currency.getDescription());
            smsDao.savePending(pendingSMS);

            return true;
        } catch (Exception ex) {
            errorHandler.handleSMSError(this.getClass(), familyPhone, ex);
            return false;
        }
    }

    public boolean notifyTransactions(String familyPhone) {
        try {
            BoFamily family = familyDao.getByPhone(familyPhone,true);
            List<BoFamilyTransaction> transactions = familyDao.getTransactionsByFamilyId(family.getId());

            StringBuilder transactionBuilder = new StringBuilder();

            if (transactions.isEmpty()) {
                transactionBuilder.append("Su familia no tiene transacciones registradas");
            } else {
                transactionBuilder.append("Su familia ha realizado las siguientes transacciones: \n");
                for (BoFamilyTransaction transaction : transactions) {
                    if (transaction.getCommerceId() != null && transaction.getCommerceId().length() > 0) {
                        transactionBuilder.append(transaction.getDescription() + " | " + DateUtils.formatDate(transaction.getCreateDate()) + " comercio: " + transaction.getCommerceDescription() + " cantidad: " + transaction.getAmount() + "\n");
                    } else {
                        transactionBuilder.append(transaction.getDescription() + " | " + DateUtils.formatDate( transaction.getCreateDate()) + " cantidad: " + transaction.getAmount() + "\n");
                    }
                }
            }

            BoPendingSMS pendingSMS = new BoPendingSMS();
            pendingSMS.setPhoneNumber(familyPhone);
            pendingSMS.setContent(transactionBuilder.toString());
            smsDao.savePending(pendingSMS);

            return true;
        } catch (Exception ex) {
            errorHandler.handleSMSError(this.getClass(), familyPhone, ex);
            return false;
        }
    }

}
