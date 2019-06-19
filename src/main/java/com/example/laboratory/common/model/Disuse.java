package com.example.laboratory.common.model;

import java.util.Date;

public class Disuse {
    private String disuseNo;
    private String deviceNo;
    private Integer disuseStaffNo;
    private Integer checkStaffNo;
    private String disuseState;
    private Date disuseDate;
    private Date disuseUpdateDate;
    private String disuseWay;

    public String getDisuseNo() {
        return disuseNo;
    }

    public void setDisuseNo(String disuseNo) {
        this.disuseNo = disuseNo;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public Integer getDisuseStaffNo() {
        return disuseStaffNo;
    }

    public void setDisuseStaffNo(Integer disuseStaffNo) {
        this.disuseStaffNo = disuseStaffNo;
    }

    public Integer getCheckStaffNo() {
        return checkStaffNo;
    }

    public void setCheckStaffNo(Integer checkStaffNo) {
        this.checkStaffNo = checkStaffNo;
    }

    public String getDisuseState() {
        return disuseState;
    }

    public void setDisuseState(String disuseState) {
        this.disuseState = disuseState;
    }

    public Date getDisuseDate() {
        return disuseDate;
    }

    public void setDisuseDate(Date disuseDate) {
        this.disuseDate = disuseDate;
    }

    public Date getDisuseUpdateDate() {
        return disuseUpdateDate;
    }

    public void setDisuseUpdateDate(Date disuseUpdateDate) {
        this.disuseUpdateDate = disuseUpdateDate;
    }

    public String getDisuseWay() {
        return disuseWay;
    }

    public void setDisuseWay(String disuseWay) {
        this.disuseWay = disuseWay;
    }

    @Override
    public String toString() {
        return "Disuse{" +
                "disuseNo='" + disuseNo + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", disuseStaffNo=" + disuseStaffNo +
                ", checkStaffNo=" + checkStaffNo +
                ", disuseState='" + disuseState + '\'' +
                ", disuseDate=" + disuseDate +
                ", disuseUpdateDate=" + disuseUpdateDate +
                ", disuseWay='" + disuseWay + '\'' +
                '}';
    }
}
