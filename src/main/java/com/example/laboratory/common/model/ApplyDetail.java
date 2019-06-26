package com.example.laboratory.common.model;

public class ApplyDetail {
    private String modelNo;
    private String applyNo;
    private Integer applyDetailQuantity;
    private String applyDetailUnit;

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public Integer getApplyDetailQuantity() {
        return applyDetailQuantity;
    }

    public void setApplyDetailQuantity(Integer applyDetailQuantity) {
        this.applyDetailQuantity = applyDetailQuantity;
    }

    public String getApplyDetailUnit() {
        return applyDetailUnit;
    }

    public void setApplyDetailUnit(String applyDetailUnit) {
        this.applyDetailUnit = applyDetailUnit;
    }

    @Override
    public String toString() {
        return "ApplyDetail{" +
                "modelNo='" + modelNo + '\'' +
                ", applyNo='" + applyNo + '\'' +
                ", applyDetailQuantity=" + applyDetailQuantity +
                ", applyDetailUnit='" + applyDetailUnit + '\'' +
                '}';
    }
}
