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
public class DaoInvalidDataException extends DaoException {

    private String invalidFieldName;
    
    public DaoInvalidDataException(String message,String invalidFieldName, Throwable cause) {
        super(message, cause);
        this.invalidFieldName = invalidFieldName;
    }

    public DaoInvalidDataException(String message, String invalidFieldName) {
        super(message);
        this.invalidFieldName = invalidFieldName;
    }

    /**
     * @return the invalidFieldName
     */
    public String getInvalidFieldName() {
        return invalidFieldName;
    }

    /**
     * @param invalidFieldName the invalidFieldName to set
     */
    public void setInvalidFieldName(String invalidFieldName) {
        this.invalidFieldName = invalidFieldName;
    }
    
}
