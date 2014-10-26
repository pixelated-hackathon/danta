/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.bo.commerce;

import pixelated.dantagae.bo.*;

/**
 *
 * @author Juan Carlos Rojas
 */
public class BoCommerce extends DaoEntity {
    
    private String name;
    private String ownerFirstName;
    private String ownerLastName;
    private String phone;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ownerFirstName
     */
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    /**
     * @param ownerFirstName the ownerFirstName to set
     */
    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    /**
     * @return the ownerLastName
     */
    public String getOwnerLastName() {
        return ownerLastName;
    }

    /**
     * @param ownerLastName the ownerLastName to set
     */
    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}