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
import org.springframework.web.servlet.ModelAndView;
import pixelated.danta.service.FamilyInformationService;
import pixelated.dantagae.bo.family.BoFamily;
/**
 *
 * @author william
 */
@Controller
public class SEASController {
    @Autowired
    private FamilyInformationService familyService;
    
    @ResponseBody
    @RequestMapping(value = "/ExpedienteDigital/Consulta", method = RequestMethod.GET, params = {"phone"})
    public ModelAndView Consulta(@RequestParam("phone") String phone) {
       ModelAndView model = new ModelAndView("expedienteDigitalConsulta");
       
        BoFamily family = familyService.findByPhone(phone);
       
       model.addObject("family", family);
       model.addObject("hold",getFamilyService().getHold(family.getId()));
       model.addObject("members",getFamilyService().getMembers(family.getId()));
       
       return model;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ExpedienteDigital/AgregarExpediente", method = RequestMethod.GET)
    public ModelAndView AgregarExpediente() {
       ModelAndView model = new ModelAndView("redirect:/web/ExpedienteDigital/Consulta");
       
       //testService.install();
       
       return model;
    }

    /**
     * @return the familyService
     */
    public FamilyInformationService getFamilyService() {
        return familyService;
    }

    /**
     * @param familyService the familyService to set
     */
    public void setFamilyService(FamilyInformationService familyService) {
        this.familyService = familyService;
    }
}
