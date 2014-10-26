/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

import org.springframework.stereotype.Repository;
import pixelated.dantagae.bo.global.BoCurrency;

/**
 *
 * @author Juan Carlos Rojas
 */
@Repository
public class GlobalDao {
   
    public BoCurrency getDefaultCurreny() {
        // TODO: Remove placeholder
        BoCurrency currency = new BoCurrency();
        currency.setCode( BoCurrency.CURRENCY_CODE );
        currency.setDescription(BoCurrency.CURRENCY_DESCRIPTION );
        return currency;
    }
    
}
