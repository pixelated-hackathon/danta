/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.dantagae.bo.family;

import java.util.Date;
import pixelated.dantagae.bo.DaoEntity;

/**
 *
 * @author Juan Carlos Rojas
 */
public class BoFamilyTransaction extends DaoEntity {
    
    private String familyId;
    private String familyDescription;
    private String commerceId;
    private String commerceDescription;
    private Date createDate;
    private Double amount;
    private String currencyCode;
    private String currencyDescription;
    private String Description;

    /**
     * @return the familyId
     */
    public String getFamilyId() {
        return familyId;
    }

    /**
     * @param familyId the familyId to set
     */
    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    /**
     * @return the commerceId
     */
    public String getCommerceId() {
        return commerceId;
    }

    /**
     * @param commerceId the commerceId to set
     */
    public void setCommerceId(String commerceId) {
        this.commerceId = commerceId;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the commerceDescription
     */
    public String getCommerceDescription() {
        return commerceDescription;
    }

    /**
     * @param commerceDescription the commerceDescription to set
     */
    public void setCommerceDescription(String commerceDescription) {
        this.commerceDescription = commerceDescription;
    }

    /**
     * @return the familyDescription
     */
    public String getFamilyDescription() {
        return familyDescription;
    }

    /**
     * @param familyDescription the familyDescription to set
     */
    public void setFamilyDescription(String familyDescription) {
        this.familyDescription = familyDescription;
    }

    /**
     * @return the currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode the currencyCode to set
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * @return the currencyDescription
     */
    public String getCurrencyDescription() {
        return currencyDescription;
    }

    /**
     * @param currencyDescription the currencyDescription to set
     */
    public void setCurrencyDescription(String currencyDescription) {
        this.currencyDescription = currencyDescription;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
	

    
    
}
