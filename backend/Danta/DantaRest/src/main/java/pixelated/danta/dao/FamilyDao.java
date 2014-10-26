/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pixelated.danta.dao.exception.DaoMessageException;
import pixelated.danta.dao.exception.DaoNotFoundException;
import pixelated.danta.dao.exception.DaoRequiredFieldException;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.dantagae.bo.family.BoFamily;
import pixelated.dantagae.bo.family.BoFamilyMember;
import pixelated.dantagae.bo.family.BoFamilyTransaction;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class FamilyDao {
    
    @Autowired
    Datasource datasource;
    
    public BoFamily getByPhone(String phone,boolean validate) throws DaoUnexpectedException, DaoMessageException {
        try {
            return datasource.findFistByField(BoFamily.class , "phone", phone, validate);
        } catch (DaoNotFoundException ex) {
            throw new DaoMessageException("El número de teléfono no corresponde a ningún beneficiario",ex);
        }
    }

    public BoFamilyTransaction saveTransaction(BoFamilyTransaction newFamilyTransaction) throws DaoUnexpectedException{
        newFamilyTransaction.setCreateDate(new Date());
        return datasource.saveEntity(newFamilyTransaction);
    }

    public void update(BoFamily family) throws DaoUnexpectedException, DaoRequiredFieldException,DaoNotFoundException {
        datasource.updateEntity(family);
    }

    public BoFamily getById( String id) throws DaoUnexpectedException, DaoNotFoundException {
       return datasource.findById(BoFamily.class ,id);
    }

    public List<BoFamily> getAll() throws DaoUnexpectedException {
       return datasource.getAll(BoFamily.class);
    }
    
    public List<BoFamilyTransaction> getTransactionsByFamilyId(String familyId) throws DaoUnexpectedException, DaoNotFoundException {
        return datasource.findByField( BoFamilyTransaction.class , "familyId", familyId, OrderByCriteria.order("createDate", OrderType.DESC),false);
    }

    public BoFamily save(BoFamily family) throws DaoUnexpectedException {
        return datasource.saveEntity(family);
    }
    
    public BoFamilyMember save(BoFamilyMember member) throws DaoUnexpectedException {
        return datasource.saveEntity(member);
    }
    
    public List<BoFamilyMember> getMembers(String id) throws DaoUnexpectedException, DaoNotFoundException{
       ParamBuilder param = new ParamBuilder();
       param.add("familyId",id);
       param.add("houseHold", "0");
       return datasource.findByFields(BoFamilyMember.class, param, true);
    }
    
    public List<BoFamilyMember> getHold(String id) throws DaoUnexpectedException, DaoNotFoundException{
       ParamBuilder param = new ParamBuilder();
       param.add("familyId",id);
       param.add("houseHold", "1");
       
       return datasource.findByFields(BoFamilyMember.class, param, true);
    }
    
}
