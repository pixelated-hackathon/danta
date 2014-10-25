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
public class DaoUnexpectedException extends DaoException {

    
    public DaoUnexpectedException(Throwable ex) {
        this("Unexpected Dao error: "+ex.getMessage(),ex);
    }

    public DaoUnexpectedException(String message,Throwable ex) {
        super(message,ex);
    }
    
}
