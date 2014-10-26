/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pixelated.danta.entities;

/**
 *
 * @author Juan Carlos Rojas
 */
public class FamilyMember {
     private String familyId;
    private String firstName;
    private String lastName;
    private boolean household;

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
    public boolean isHousehold() {
        return household;
    }

    /**
     * @param household the household to set
     */
    public void setHousehold(boolean household) {
        this.household = household;
    }
}
