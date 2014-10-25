/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao.exception;

/**
 *
 * @author Juan Carlos Rojas
 */
public class DaoRequiredFieldException extends DaoException {
 
    private String fieldName;
    private String className;

    public <T> DaoRequiredFieldException(Class<T> entityClass,String fieldName) {
        super(entityClass.getSimpleName()+"."+fieldName +" was not specified");
        this.fieldName = fieldName;
        this.className = entityClass.getSimpleName();
    }
    
    public <T> DaoRequiredFieldException(String fieldName) {
        super("Field "+fieldName +" was not specified");
        this.fieldName = fieldName;
    }

    /**
     * @return the fieldName
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * @param fieldName the fieldName to set
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
    
    
}
