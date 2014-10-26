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
    
    public TestService() {
    }

    public boolean install(){
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
            newMember.setFamilyId( testFamily.getId() );
            datasource.saveEntity(newMember );
            newMember = new BoFamilyMember();
            newMember.setFirstName("Kevin");
            newMember.setLastName("Rodriguez");
            newMember.setHousehold(false);
            newMember.setFamilyId( testFamily.getId() );
            datasource.saveEntity(newMember );
            
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
}
