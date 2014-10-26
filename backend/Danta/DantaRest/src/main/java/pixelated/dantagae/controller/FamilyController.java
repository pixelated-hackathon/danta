/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pixelated.danta.service.FamilyInformationService;
import pixelated.dantagae.bo.family.BoFamily;

/**
 *
 * @author Juan Carlos Rojas
 */
@Controller
public class FamilyController {
    
    @Autowired
    FamilyInformationService familyService;
    
    
    @ResponseBody
    @RequestMapping(value = "/family",method = RequestMethod.GET)
    public List<BoFamily> getAllFamilies() {
        return familyService.getAll();
    }
    
    @ResponseBody
    @RequestMapping(value = "/family/{id}",method = RequestMethod.GET)
    public BoFamily getFamily(@PathVariable String id ) {
        return familyService.getByID(id);
    }
    
}
