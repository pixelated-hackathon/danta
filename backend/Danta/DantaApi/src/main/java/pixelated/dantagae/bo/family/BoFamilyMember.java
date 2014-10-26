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
public class BoFamilyMember extends DaoEntity {
    
    private String familyId;
    private String firstName;
    private String lastName;
    private String idCard;
    private String occupationDescription;
    private Date birthday;
    
    private String household;

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the household
     */
    public String isHousehold() {
        return household;
    }

    /**
     * @param household the household to set
     */
    public void setHousehold(String household) {
        this.household = household;
    }

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
     * @return the idCard
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard the idCard to set
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return the occupationDescription
     */
    public String getOccupationDescription() {
        return occupationDescription;
    }

    /**
     * @param occupationDescription the occupationDescription to set
     */
    public void setOccupationDescription(String occupationDescription) {
        this.occupationDescription = occupationDescription;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
}
