/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pixelated.danta.dao.exception.DaoException;
import pixelated.danta.service.SMSDispatcher;
import pixelated.dantagae.sms.BoPendingSMS;

/**
 *
 * @author Juan Carlos Rojas
 */
@Controller
public class SMSController {
    
    @Autowired
    SMSDispatcher smsService;
    
    @ResponseBody
    @RequestMapping(value = "/sms/push",method = RequestMethod.POST, params = {"phone","content"})
    public boolean pushSMS(@RequestParam("phone") String phone,@RequestParam("content") String content) throws DaoException {
        return smsService.pushSMS(phone,content);
    }
    
    @ResponseBody
    @RequestMapping(value = "/sms/pull",method = RequestMethod.GET)
    public List<BoPendingSMS> pullSMS() throws DaoException {
        return smsService.pullSMS();
    }
}
