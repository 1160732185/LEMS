package com.example.laboratory.common.model;

import java.util.Date;

public class Firm {
    private Integer firmNo;
    private String firmName;
    private String firmAddress;
    private String firmContacter;
    private String firmTelephone;
    private String firmEmail;
    private Date firmAddDate;

    public Integer getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(Integer firmNo) {
        this.firmNo = firmNo;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmAddress() {
        return firmAddress;
    }

    public void setFirmAddress(String firmAddress) {
        this.firmAddress = firmAddress;
    }

    public String getFirmContacter() {
        return firmContacter;
    }

    public void setFirmContacter(String firmContacter) {
        this.firmContacter = firmContacter;
    }

    public String getFirmTelephone() {
        return firmTelephone;
    }

    public void setFirmTelephone(String firmTelephone) {
        this.firmTelephone = firmTelephone;
    }

    public String getFirmEmail() {
        return firmEmail;
    }

    public void setFirmEmail(String firmEmail) {
        this.firmEmail = firmEmail;
    }

    public Date getFirmAddDate() {
        return firmAddDate;
    }

    public void setFirmAddDate(Date firmAddDate) {
        this.firmAddDate = firmAddDate;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "firmNo=" + firmNo +
                ", firmName='" + firmName + '\'' +
                ", firmAddress='" + firmAddress + '\'' +
                ", firmContacter='" + firmContacter + '\'' +
                ", firmTelephone='" + firmTelephone + '\'' +
                ", firmEmail='" + firmEmail + '\'' +
                ", firmAddDate=" + firmAddDate +
                '}';
    }
}
