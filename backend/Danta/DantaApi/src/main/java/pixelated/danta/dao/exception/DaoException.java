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
public abstract class DaoException extends Exception {
    
    public DaoException(String message,Throwable cause) {
        super(message,cause);
    }
    
    public DaoException(String message) {
        super(message);
    }
    
}
