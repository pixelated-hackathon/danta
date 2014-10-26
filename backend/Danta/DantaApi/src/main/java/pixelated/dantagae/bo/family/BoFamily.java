/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.bo.family;

import pixelated.dantagae.bo.DaoEntity;

/**
 *
 * @author Juan Carlos Rojas
 */
public class BoFamily extends DaoEntity {
    
    private String familyLastName;
    private String phone;
    private Double funds;

    /**
     * @return the familyLastName
     */
    public String getFamilyLastName() {
        return familyLastName;
    }

    /**
     * @param familyLastName the familyLastName to set
     */
    public void setFamilyLastName(String familyLastName) {
        this.familyLastName = familyLastName;
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

    /**
     * @return the funds
     */
    public Double getFunds() {
        return funds;
    }

    /**
     * @param funds the funds to set
     */
    public void setFunds(Double funds) {
        this.funds = funds;
    }
    
}
