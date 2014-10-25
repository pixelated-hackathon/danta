/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.bo;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Juan Carlos Rojas
 */
public class TestValue {
  
    @Id
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
                "TestValue[id=%s, firstName='%d']",
                value, date);
    }

}