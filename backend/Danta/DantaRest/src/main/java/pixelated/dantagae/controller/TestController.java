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
import pixelated.danta.service.TestService;

/**
 *
 * @author Juan Carlos Rojas
 */
@Controller
public class TestController {
    
    @Autowired
    TestService testService;
    
    
    @ResponseBody
    @RequestMapping(value = "/install", method = RequestMethod.GET)
    public boolean install() {
       return testService.install();
    }
    
    
    
    
}
