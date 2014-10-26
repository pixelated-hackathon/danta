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
    
    public boolean doPayment(String familyId, String commerceId, Long amount) {
        try {
            
            return true;
        } catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);
            return false;
        }
    }
    
    
}
