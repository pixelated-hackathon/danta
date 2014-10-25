/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.dao;

import test.bo.TestValue;



/**
 *
 * @author Juan Carlos Rojas
 */
public interface TestDao  {
    
    TestValue save(TestValue value);
    
    
}
