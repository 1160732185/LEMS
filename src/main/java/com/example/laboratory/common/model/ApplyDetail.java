package com.example.laboratory.common.model;

public class ApplyDetail {
    private String modelName;
    private String applyNo;
    private Integer applyDetailQuantity;
    private String applyDetailUnit;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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
                "modelName='" + modelName + '\'' +
                ", applyNo='" + applyNo + '\'' +
                ", applyDetailQuantity=" + applyDetailQuantity +
                ", applyDetailUnit='" + applyDetailUnit + '\'' +
                '}';
    }
}
