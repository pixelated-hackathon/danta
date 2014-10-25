/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

import java.util.List;
import pixelated.danta.dao.exception.DaoNotFoundException;
import pixelated.danta.dao.exception.DaoRequiredFieldException;
import pixelated.danta.dao.exception.DaoUnexpectedException;
import pixelated.dantagae.bo.DaoEntity;

/**
 *
 * @author Juan Carlos Rojas
 */
public interface EntityDao {

    <T extends DaoEntity> T findById(Class<T> entityClass, String id) throws DaoUnexpectedException, DaoNotFoundException;

    <T extends DaoEntity> T saveEntity(T entity) throws DaoUnexpectedException;

    void updateEntity(DaoEntity entity) throws DaoUnexpectedException, DaoRequiredFieldException, DaoNotFoundException;

     <T extends DaoEntity> List<T> getAll(Class<T> entityClass) throws DaoUnexpectedException;
    
}
