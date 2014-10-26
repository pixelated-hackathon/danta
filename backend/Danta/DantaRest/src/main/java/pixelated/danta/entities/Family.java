/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixelated.danta.entities;

import java.util.List;

/**
 *
 * @author Juan Carlos Rojas
 */
public class Family {

    private String id;
    private String familyLastName;
    private String phone;

    private List<FamilyMember> members;


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
     * @return the members
     */
    public List<FamilyMember> getMembers() {
        return members;
    }

    /**
     * @param members the members to set
     */
    public void setMembers(List<FamilyMember> members) {
        this.members = members;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

}
