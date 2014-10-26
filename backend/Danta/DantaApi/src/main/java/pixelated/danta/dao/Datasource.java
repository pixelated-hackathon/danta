/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

import java.util.List;
import java.util.Map;
import pixelated.danta.dao.exception.DaoException;
import pixelated.danta.dao.exception.DaoNotFoundException;
import pixelated.danta.dao.exception.DaoRequiredFieldException;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.dantagae.bo.DaoEntity;
import pixelated.dantagae.sms.BoPendingSMS;

/**
 *
 * @author Juan Carlos Rojas
 */
public interface Datasource {

    <T extends DaoEntity> T findById(Class<T> entityClass, String id) throws DaoUnexpectedException, DaoNotFoundException;

    <T extends DaoEntity> T saveEntity(T entity) throws DaoUnexpectedException;

    void updateEntity(DaoEntity entity) throws DaoUnexpectedException, DaoRequiredFieldException, DaoNotFoundException;

     <T extends DaoEntity> List<T> getAll(Class<T> entityClass) throws DaoUnexpectedException;
    
     <T extends DaoEntity> long drop(Class<T> entityClass);
     
    <T extends DaoEntity> List<T> findByFields(Class<T> entityClass, ParamBuilder values, boolean validate) throws DaoUnexpectedException,DaoNotFoundException;
     
    <T extends DaoEntity> List<T> findByField(Class<T> entityClass,String field, Object value, boolean validate) throws DaoUnexpectedException,DaoNotFoundException;
    
    <T extends DaoEntity> T findFistByField(Class<T> entityClass,String field, Object value, boolean validate) throws DaoUnexpectedException,DaoNotFoundException;
    
    <T extends DaoEntity> T findFistByFields(Class<T> entityClass,ParamBuilder values, boolean validate) throws DaoUnexpectedException,DaoNotFoundException;
    
    <T extends DaoEntity> void delete(T entity) throws DaoRequiredFieldException;
    
}
