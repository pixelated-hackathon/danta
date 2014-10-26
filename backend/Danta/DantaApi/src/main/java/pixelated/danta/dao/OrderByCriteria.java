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
public class OrderByCriteria {

    private OrderType orderType;
    private String field;

    public OrderByCriteria(String field, OrderType orderType ) {
        this.field = field;
        this.orderType = orderType;
    }
    
    public static OrderByCriteria order(String field, OrderType orderType) {
        return new OrderByCriteria(field,orderType);
    }
    
    public static OrderByCriteria order(String field) {
        return order(field,OrderType.ASC);
    }

    /**
     * @return the orderType
     */
    public OrderType getOrderType() {
        return orderType;
    }

    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the fields to set
     */
    public void setField(String field) {
        this.field = field;
    }
    
}
