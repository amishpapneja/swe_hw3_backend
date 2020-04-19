package swe645_assignment3_1;


import java.io.Serializable;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="STUDENTINFO")
@NamedNativeQuery(name="get_all_studentIds",query="select USERID from STUDENTINFO")
public class Student implements Serializable {
    @Id
    private String USERID;

    private String FIRSTNAME;
    private String LASTNAME;
    private String ADDRESS;
    private String CITY;
    private String STATE;
    private String ZIPCODE;
    private String PHONE;
    private String EMAIL;
    private String USER_DATE;
    private String CHECKBOX;
    private String RADIO;
    private String SELECTION;


    public String getUSERID() {
        return USERID;
    }

    public void setUSERID(String USERID) {
        this.USERID = USERID;
    }

    public String getFIRSTNAME() {
        return FIRSTNAME;
    }

    public void setFIRSTNAME(String FIRSTNAME) {
        this.FIRSTNAME = FIRSTNAME;
    }

    public String getLASTNAME() {
        return LASTNAME;
    }

    public void setLASTNAME(String LASTNAME) {
        this.LASTNAME = LASTNAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSTATE() {
        return STATE;
    }

    public void setSTATE(String STATE) {
        this.STATE = STATE;
    }

    public String getZIPCODE() {
        return ZIPCODE;
    }

    public void setZIPCODE(String ZIPCODE) {
        this.ZIPCODE = ZIPCODE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getUSER_DATE() {
        return USER_DATE;
    }

    public void setUSER_DATE(String USER_DATE) {
        this.USER_DATE = USER_DATE;
    }

    public String getCHECKBOX() {
        return CHECKBOX;
    }

    public void setCHECKBOX(String CHECKBOX) {
        this.CHECKBOX = CHECKBOX;
    }

    public String getRADIO() {
        return RADIO;
    }

    public void setRADIO(String RADIO) {
        this.RADIO = RADIO;
    }

    public String getSELECTION() {
        return SELECTION;
    }

    public void setSELECTION(String SELECTION) {
        this.SELECTION = SELECTION;
    }

    @Override
    public String toString() {
        return "User ID: " + this.USERID + " Name: " + this.FIRSTNAME + " " + this.LASTNAME + " Phone :" +this.getPHONE()
                + "\n" + "Email: " + this.getEMAIL() + " Zip Code: " + this.getZIPCODE() + " City: " + this.getCITY()
                +"Date: " + this.USER_DATE + " "  ;

    }


}
