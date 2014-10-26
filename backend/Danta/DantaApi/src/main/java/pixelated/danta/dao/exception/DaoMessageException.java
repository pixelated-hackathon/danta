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
public class DaoMessageException extends Exception {

    public DaoMessageException(String message) {
        super(message);
    }

    public DaoMessageException(String message , Throwable ex) {
        super(message,ex);
    }
    
    
    
    
}
