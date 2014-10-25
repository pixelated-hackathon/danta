/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.bo;

import java.util.Date;

/**
 *
 * @author Juan Carlos Rojas
 */
public class TestValue {
  
    private String id;
    private String value;
    private Date date;
    public TestValue() {}

    public TestValue(String value) {
        this.value = value;
        this.date= new Date();
    }

    @Override
    public String toString() {
        return String.format(
                "TestValue[id=%s, firstName='%d']", getValue(), getDate());
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}