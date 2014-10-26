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
    private String commerceId;
    private Date createDate;
    private Double amount;

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
	

    
    
}
