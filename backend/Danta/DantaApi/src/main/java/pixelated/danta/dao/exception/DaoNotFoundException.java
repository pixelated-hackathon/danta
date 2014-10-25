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
public class DaoNotFoundException extends DaoException {

    private String entityName;
    private String searchField;
    private String searchValue;
    
    public DaoNotFoundException(Class entity, String searchField,String searchValue) {
        this(entity.getSimpleName(),searchField, searchValue);
    }
    
    public DaoNotFoundException(Class entity, String criteriaDesc) {
        this(entity.getSimpleName(),criteriaDesc);
    }
    
    public DaoNotFoundException(String entityName, String criteriaDesc) {
         super("Could not find " + entityName +" with criteria "+criteriaDesc);
    }
    
    public DaoNotFoundException(String entityName, String searchField, String searchValue) {
        this("Could not find " + entityName + " with " + searchField + " value " + searchValue,entityName,searchField,searchValue);
    }
    
    private DaoNotFoundException(String message, String entityName, String searchField, String searchValue) {
        super(message);
        this.entityName = entityName;
        this.searchField = searchField;
        this.searchValue = searchValue;

    }

    /**
     * @return the entityName
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * @param entityName the entityName to set
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * @return the searchField
     */
    public String getSearchField() {
        return searchField;
    }

    /**
     * @param searchField the searchField to set
     */
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

}
