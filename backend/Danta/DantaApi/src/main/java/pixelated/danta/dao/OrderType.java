/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.dao;

/**
 *
 * @author Juan Carlos Rojas
 */
public enum OrderType {
    ASC("asc"), DESC("desc");
    
    String orderStr;

    OrderType(String orderStr) {
        this.orderStr = orderStr;
    }

    @Override
    public String toString() {
        return orderStr;
    }
}
