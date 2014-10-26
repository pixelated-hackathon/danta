/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import pixelated.danta.dao.exception.DaoMessageException;
import pixelated.danta.dao.exception.DaoNotFoundException;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.dantagae.bo.family.BoFamily;

/**
 *
 * @author Juan Carlos Rojas
 */
public class FamilyDao {
    
    @Autowired
    Datasource datasource;
    
    public BoFamily getByPhone(String phone) throws DaoUnexpectedException, DaoMessageException {
        try {
            return datasource.findByField(BoFamily.class , "phone", phone, true);
        } catch (DaoNotFoundException ex) {
            throw new DaoMessageException("El número de teléfono no corresponde a ninguna familia registrada",ex);
        }
    }
    
    
    
}
