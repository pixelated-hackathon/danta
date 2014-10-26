/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.exception.DaoMessageException;
import pixelated.danta.dao.exception.DaoNotFoundException;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.dantagae.bo.commerce.BoCommerce;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class CommerceDao {
    
    @Autowired
    Datasource datasource;
    
    public BoCommerce getByPhone(String phone) throws DaoUnexpectedException, DaoMessageException {
        try {
            return datasource.findFistByField(BoCommerce.class , "phone", phone, true);
        } catch (DaoNotFoundException ex) {
            throw new DaoMessageException("El número de teléfono no corresponde a ningún comercio registrado",ex);
        }
    }
    
    
    
}
