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
import pixelated.danta.service.FamilyPaymentService;
import pixelated.dantagae.bo.family.BoFamily;

/**
 *
 * @author william
 */
@Controller
public class SEASController {

    @Autowired
    private FamilyInformationService familyService;
    
    @Autowired
    private FamilyPaymentService payment;
    
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
    @RequestMapping(value = "/ExpedienteDigital/SaludFinanciera", method = RequestMethod.GET, params = {"phone"})
    public ModelAndView SaludFinanciera(@RequestParam("phone") String phone) {
       ModelAndView model = new ModelAndView("saludFinanciera");
       
       BoFamily family = familyService.findByPhone(phone);
       
       model.addObject("family", family);
       
       return model;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ExpedienteDigital/SaludFinancieraResultado", method = RequestMethod.GET, params = {"phone"})
    public ModelAndView SaludFinancieraResultado(@RequestParam("phone") String phone) {
       ModelAndView model = new ModelAndView("saludFinancieraResultado");
       
       BoFamily family = familyService.findByPhone(phone);
       
       model.addObject("family", family);
       
       return model;
    }

    @ResponseBody
    @RequestMapping(value = "/ExpedienteDigital/AgregarExpediente", method = RequestMethod.GET, params = {"phone"})
    public ModelAndView AgregarExpediente(@RequestParam("phone") String phone) {
        ModelAndView model = new ModelAndView("redirect:/web/ExpedienteDigital/Consulta");

        BoFamily family = familyService.findByPhone(phone);

        model.addObject("family", family);

        return model;
    }

    @ResponseBody
    @RequestMapping(value = "/ExpedienteDigital/HistorialTransacciones", method = RequestMethod.GET, params = {"phone"})
    public ModelAndView HistorialTransacciones(@RequestParam("phone") String phone) {
       ModelAndView model = new ModelAndView("historialTransacciones");
       
       BoFamily family = familyService.findByPhone(phone);
       
       model.addObject("family", family);
       model.addObject("transactions",familyService.getTransactions(family.getId()));
       
       return model;
    }

    @ResponseBody
    @RequestMapping(value = "/ExpedienteDigital/Desembolso", method = RequestMethod.GET, params = {"phone"})
    public ModelAndView Desembolso(@RequestParam("phone") String phone, @RequestParam(value = "amount", required = false) Double amount) {
        ModelAndView model = new ModelAndView("desembolso");
        model.addObject("phone", phone);
        BoFamily family = familyService.findByPhone(phone);
        if (amount != null) {
            
            payment.addFunds(family.getId(), amount);
            
            model.addObject("amount", amount);
        }
        model.addObject("family",family);

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

    /**
     * @return the payment
     */
    public FamilyPaymentService getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(FamilyPaymentService payment) {
        this.payment = payment;
    }
}
