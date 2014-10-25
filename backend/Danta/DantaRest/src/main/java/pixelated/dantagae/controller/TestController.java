/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pixelated.dantagae.service.TestService;

/**
 *
 * @author Juan Carlos Rojas
 */
@Controller
public class TestController {
    
    @Autowired
    TestService testService;
    
    /**
     * Retrieves the backed version
     * @return A string representation of the backed version
     */
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest() {
       return "hello";
    }
    
    @ResponseBody
    @RequestMapping(value = "/store", method = RequestMethod.GET, params = {"value"})
    public boolean storeTest(@RequestParam("value") String value) {
       return testService.storeValue(value);
    }
    
}
