package com.example.laboratory.common.model;

import java.util.Date;

public class Device {
     private String deviceNo;
     private Integer staffNo;
     private Integer firmNo;
     private String modelNo;
     private Integer roomNo;
     private Date deviceAddDate;
     private String deviceState;

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public Integer getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public Integer getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(Integer firmNo) {
        this.firmNo = firmNo;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public Date getDeviceAddDate() {
        return deviceAddDate;
    }

    public void setDeviceAddDate(Date deviceAddDate) {
        this.deviceAddDate = deviceAddDate;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceNo='" + deviceNo + '\'' +
                ", staffNo=" + staffNo +
                ", firmNo=" + firmNo +
                ", modelNo='" + modelNo + '\'' +
                ", roomNo=" + roomNo +
                ", deviceAddDate=" + deviceAddDate +
                ", deviceState='" + deviceState + '\'' +
                '}';
    }
}
