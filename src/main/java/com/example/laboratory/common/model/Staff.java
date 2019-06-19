package com.example.laboratory.common.model;
import java.util.Date;
public class Staff {
    private Integer staffNo;
    private String staffName;
    private String staffSex;
    private String staffEmail;
    private String staffPassword;
    private String staffTelephone;
    private String staffDuty;
    private Date staffRegisterTime;

    public Integer getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffTelephone() {
        return staffTelephone;
    }

    public void setStaffTelephone(String staffTelephone) {
        this.staffTelephone = staffTelephone;
    }

    public String getStaffDuty() {
        return staffDuty;
    }

    public void setStaffDuty(String staffDuty) {
        this.staffDuty = staffDuty;
    }

    public Date getStaffRegisterTime() {
        return staffRegisterTime;
    }

    public void setStaffRegisterTime(Date staffRegisterTime) {
        this.staffRegisterTime = staffRegisterTime;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffNo=" + staffNo +
                ", staffName='" + staffName + '\'' +
                ", staffSex='" + staffSex + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", staffPassword='" + staffPassword + '\'' +
                ", staffTelephone='" + staffTelephone + '\'' +
                ", staffDuty='" + staffDuty + '\'' +
                ", staffRegisterTime=" + staffRegisterTime +
                '}';
    }
}
