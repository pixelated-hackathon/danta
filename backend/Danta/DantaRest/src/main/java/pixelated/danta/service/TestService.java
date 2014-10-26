/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pixelated.danta.dao.Datasource;
import pixelated.danta.dao.FamilyDao;
import pixelated.danta.dao.exception.DaoAlreadyExistsException;
import pixelated.danta.dao.exception.DaoMessageException;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.dantagae.bo.commerce.BoCommerce;
import pixelated.dantagae.bo.family.BoFamily;
import pixelated.dantagae.bo.family.BoFamilyMember;

/**
 *
 * @author Juan Carlos Rojas
 */
@Service
public class TestService {

    @Autowired
    Datasource datasource;
    
    @Autowired
    FamilyDao familyDao;

    public TestService() {
    }

    public boolean install() {
        try {

            datasource.drop(BoFamily.class);
            datasource.drop(BoFamilyMember.class);
            datasource.drop(BoCommerce.class);

            BoFamily testFamily = new BoFamily();
            testFamily.setFamilyLastName("Rojas");
            testFamily.setFunds(60000d);
            testFamily.setPhone("87040233");
            datasource.saveEntity(testFamily);

            BoFamilyMember newMember = new BoFamilyMember();
            newMember.setFirstName("Mario");
            newMember.setLastName("Rodriguez");
            newMember.setHousehold(true);
            newMember.setFamilyId(testFamily.getId());
            datasource.saveEntity(newMember);
            newMember = new BoFamilyMember();
            newMember.setFirstName("Kevin");
            newMember.setLastName("Rodriguez");
            newMember.setHousehold(false);
            newMember.setFamilyId(testFamily.getId());
            datasource.saveEntity(newMember);

            testFamily = new BoFamily();
            testFamily.setFamilyLastName("Castro");
            testFamily.setFunds(60000d);
            testFamily.setPhone("60590718");
            datasource.saveEntity(testFamily);

            newMember = new BoFamilyMember();
            newMember.setFirstName("Ana");
            newMember.setLastName("Castro");
            newMember.setHousehold(true);
            newMember.setFamilyId(testFamily.getId());
            datasource.saveEntity(newMember);
            newMember = new BoFamilyMember();
            newMember.setFirstName("Carlos");
            newMember.setLastName("Rodriguez");
            newMember.setHousehold(false);
            newMember.setFamilyId(testFamily.getId());
            datasource.saveEntity(newMember);

            BoCommerce commerce = new BoCommerce();
            commerce.setName("Abastecedor Don Carlos");
            commerce.setOwnerFirstName("Carlos");
            commerce.setOwnerLastName("Rojas");
            commerce.setPhone("70509709");
            datasource.saveEntity(commerce);

            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().toString()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void registerFamily(String number, String firstName, String lastName) throws DaoUnexpectedException, DaoMessageException {

        BoFamily existingFamily  = familyDao.getByPhone(number,false);
        if (existingFamily != null) {
            throw new DaoMessageException("Ya existe una familia con el número de teléfono");
        }
        
        BoFamily testFamily = new BoFamily();
        testFamily.setFamilyLastName(lastName);
        testFamily.setFunds(generateRandomNumber( 1000 , 6000 ));
        testFamily.setPhone(number);
        datasource.saveEntity(testFamily);

        BoFamilyMember newMember = new BoFamilyMember();
        newMember.setFirstName(firstName);
        newMember.setLastName(lastName);
        newMember.setHousehold(true);
        newMember.setFamilyId(testFamily.getId());
        datasource.saveEntity(newMember);
    }
    
    
    protected double generateRandomNumber(int from, int to) {
        int dif = Math.abs(to - from);
        int random = Math.round(new Float(Math.random() * dif).floatValue());
        return random + Math.min(from, to);
    }
}
