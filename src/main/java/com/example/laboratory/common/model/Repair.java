package com.example.laboratory.common.model;

import java.util.Date;

public class Repair {
    private String repairNo;
    private String deviceNo;
    private Integer firmNo;
    private Integer staffNo;
    private Integer repairPrice;
    private Date repairDate;
    private Date repairFinishDate;
    private String repairResult;

    public String getRepairNo() {
        return repairNo;
    }

    public void setRepairNo(String repairNo) {
        this.repairNo = repairNo;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public Integer getFirmNo() {
        return firmNo;
    }

    public void setFirmNo(Integer firmNo) {
        this.firmNo = firmNo;
    }

    public Integer getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(Integer staffNo) {
        this.staffNo = staffNo;
    }

    public Integer getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(Integer repairPrice) {
        this.repairPrice = repairPrice;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Date getRepairFinishDate() {
        return repairFinishDate;
    }

    public void setRepairFinishDate(Date repairFinishDate) {
        this.repairFinishDate = repairFinishDate;
    }

    public String getRepairResult() {
        return repairResult;
    }

    public void setRepairResult(String repairResult) {
        this.repairResult = repairResult;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairNo='" + repairNo + '\'' +
                ", deviceNo='" + deviceNo + '\'' +
                ", firmNo=" + firmNo +
                ", staffNo=" + staffNo +
                ", repairPrice=" + repairPrice +
                ", repairDate=" + repairDate +
                ", repairFinishDate=" + repairFinishDate +
                ", repairResult='" + repairResult + '\'' +
                '}';
    }
}
