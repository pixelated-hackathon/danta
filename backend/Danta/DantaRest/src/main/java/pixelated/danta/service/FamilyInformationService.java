/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pixelated.danta.dao.Datasource;
import pixelated.danta.dao.FamilyDao;
import pixelated.danta.dao.SMSDao;
import pixelated.danta.entities.Family;
import pixelated.danta.entities.FamilyMember;
import pixelated.danta.service.logic.ErrorHandler;
import pixelated.dantagae.bo.family.BoFamily;
import pixelated.dantagae.bo.family.BoFamilyMember;
import pixelated.dantagae.bo.family.BoFamilyTransaction;
import pixelated.dantagae.sms.BoPendingSMS;

/**
 *
 * @author william
 */
@Service
public class FamilyInformationService {

    @Autowired
    FamilyDao familyDao;

    @Autowired
    SMSDao smsDao;

    @Autowired
    Datasource datasource;

    public FamilyInformationService() {
    }

    public BoFamily getByID(String id) {
        try {
            return familyDao.getById(id);
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().toString()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<BoFamily> getAll() {
        try {
            return familyDao.getAll();
        } catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);
            return null;
        }
    }
    
    public BoFamily findByPhone(String phone) {
        try {
            return familyDao.getByPhone(phone, false);
        } catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);
            return null;
        }
    }

    public Family registerFamily(Family family) {
        try {

            BoFamily newFamily = new BoFamily();
            newFamily.setFamilyLastName(family.getFamilyLastName());
            newFamily.setFunds(0d);
            newFamily.setPhone(family.getPhone());
            newFamily = familyDao.save(newFamily);
            family.setId(newFamily.getId());
            
            
            if (family.getMembers() != null) {
                for (FamilyMember member : family.getMembers()) {
                    BoFamilyMember newMember = new BoFamilyMember();
                    newMember.setFirstName(member.getFirstName());
                    newMember.setLastName(member.getLastName());
                    if (member.isHousehold()) {
                        newMember.setHousehold("1" );
                    } else {
                        newMember.setHousehold("0" );
                    }
                    newMember.setFamilyId(newFamily.getId());
                    familyDao.save(newMember);
                }
            }

            BoPendingSMS pendingSMS = new BoPendingSMS();
            pendingSMS.setPhoneNumber(family.getPhone());
            pendingSMS.setContent("Su familia ha sido aprobada para el programa de apoyo económico SEAS");
            smsDao.savePending(pendingSMS);

            return family;

        } catch (Exception ex) {
            Logger.getLogger(this.getClass().toString()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<BoFamilyMember> getMembers(String familyId){
        try{
            return familyDao.getMembers(familyId);
        }catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);

            return null;
        }
    }
    
    public BoFamilyMember getHold(String familyId){
        try{
            return familyDao.getHold(familyId).get(0);
        }catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);

            return null;
        }
    }
    
    public List<BoFamilyTransaction> getTransactions(String id){
        try{
            return familyDao.getTransactionsByFamilyId(id);
        }catch (Exception ex) {
            ErrorHandler.handleError(this.getClass(), ex);
            return null;
        }
    }
}
