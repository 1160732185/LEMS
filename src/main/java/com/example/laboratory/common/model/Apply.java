package com.example.laboratory.common.model;

import java.util.Date;

public class Apply {
    private String applyNo;
    private Integer applyStaffNo;
    private Integer checkStaffNo;
    private Date applyDate;
    private String applyReason;
    private String applyType;
    private String applyState;
    private Date applyUpdateDate;
    private String applyUpdateInfo;

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public Integer getApplyStaffNo() {
        return applyStaffNo;
    }

    public void setApplyStaffNo(Integer applyStaffNo) {
        this.applyStaffNo = applyStaffNo;
    }

    public Integer getCheckStaffNo() {
        return checkStaffNo;
    }

    public void setCheckStaffNo(Integer checkStaffNo) {
        this.checkStaffNo = checkStaffNo;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public Date getApplyUpdateDate() {
        return applyUpdateDate;
    }

    public void setApplyUpdateDate(Date applyUpdateDate) {
        this.applyUpdateDate = applyUpdateDate;
    }

    public String getApplyUpdateInfo() {
        return applyUpdateInfo;
    }

    public void setApplyUpdateInfo(String applyUpdateInfo) {
        this.applyUpdateInfo = applyUpdateInfo;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyNo='" + applyNo + '\'' +
                ", applyStaffNo=" + applyStaffNo +
                ", checkStaffNo=" + checkStaffNo +
                ", applyDate=" + applyDate +
                ", applyReason='" + applyReason + '\'' +
                ", applyType='" + applyType + '\'' +
                ", applyState='" + applyState + '\'' +
                ", applyUpdateDate=" + applyUpdateDate +
                ", applyUpdateInfo='" + applyUpdateInfo + '\'' +
                '}';
    }
}
