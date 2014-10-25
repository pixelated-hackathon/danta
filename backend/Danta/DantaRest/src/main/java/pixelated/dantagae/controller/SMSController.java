/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Juan Carlos Rojas
 */
@Controller
public class SMSController {
    
    @ResponseBody
    @RequestMapping(value = "/sms/push",method = RequestMethod.POST, params = {"phone","content"})
    public boolean storeTest(@RequestParam("phone") String phone,@RequestParam("content") String content) {
        return true;
    }
}
