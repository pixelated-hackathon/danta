/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao.exception;

/**
 *
 * @author jrojas
 */
public class DaoAlreadyExistsException extends DaoException {
    
    String fieldDescription;
    String entityDescription;
    String identificationValue;
    
    public DaoAlreadyExistsException(Class entity) {
        super( entity.getSimpleName() + " already exists" );
        this.entityDescription = entity.getSimpleName();
    }
    
    
    public DaoAlreadyExistsException(Class entity, String identificationValue) {
        this(entity.getSimpleName(),identificationValue);
    }
    
    
    public DaoAlreadyExistsException(String entityDescription, String identificationValue) {
        this(entityDescription,"ID",identificationValue,null);
    }
    
    public DaoAlreadyExistsException(Class entity, String fieldDescription,String identificationValue ) {
        this(entity.getSimpleName(), fieldDescription,identificationValue,null);
    }
    
    public DaoAlreadyExistsException(Class entity, String fieldDescription,String identificationValue, Throwable cause  ) {
        this(entity.getSimpleName(), fieldDescription,identificationValue,cause);
    }
    
    public DaoAlreadyExistsException(String entityDescription, String fieldDescription,String identificationValue, Throwable cause  ) {
        super(entityDescription + " with "+fieldDescription+" : "+identificationValue+" already exists",cause);
        this.entityDescription = entityDescription;
        this.fieldDescription = fieldDescription;
        this.identificationValue = identificationValue;
    } 
}
