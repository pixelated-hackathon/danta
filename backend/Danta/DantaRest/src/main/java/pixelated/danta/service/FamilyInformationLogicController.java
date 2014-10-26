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
import pixelated.dantagae.bo.commerce.BoCommerce;
import pixelated.dantagae.bo.family.BoFamily;
import pixelated.dantagae.bo.family.BoFamilyMember;
/**
 *
 * @author william
 */
@Service
public class FamilyInformationLogicController {
    @Autowired
    Datasource datasource;
    
    public FamilyInformationLogicController(){}
    
    public BoFamily getByID(String id){
        try{
            return datasource.findById(BoFamily.class,id);
        }catch (Exception ex) {
            Logger.getLogger(this.getClass().toString()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
