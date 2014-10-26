/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.CommerceDao;
import pixelated.danta.dao.FamilyDao;
import pixelated.danta.service.logic.ErrorHandler;
import pixelated.dantagae.bo.commerce.BoCommerce;
import pixelated.dantagae.bo.family.BoFamily;
import pixelated.dantagae.bo.family.BoFamilyTransaction;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class FamilyPaymentLogicController {
    
    @Autowired
    ErrorHandler errorHandler;
    
    
    @Autowired
    CommerceDao commerceDao;
    @Autowired
    FamilyDao familyDao;
    
    public boolean doPayment(String familyPhone, String commercePhone, Double amount) {
        try {
            BoFamily family = familyDao.getByPhone(familyPhone);
            BoCommerce commerce = commerceDao.getByPhone(commercePhone);
            
            BoFamilyTransaction newFamilyTransaction = new BoFamilyTransaction();
            newFamilyTransaction.setCommerceId(commerce.getId());
            newFamilyTransaction.setFamilyId(family.getId());
            newFamilyTransaction.setAmount(amount * -1);
            familyDao.saveTransaction(newFamilyTransaction);
            
            family.setFunds( family.getFunds() - amount ); 
            
            familyDao.update(family);
            
            return true;
        } catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);
            return false;
        }
    } 
}
