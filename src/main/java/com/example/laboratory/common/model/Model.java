package com.example.laboratory.common.model;

public class Model {
    private String modelNo;
    private String modelName;
    private String modelType;
    private String modelNorm;
    private Double modelPrice;

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelNorm() {
        return modelNorm;
    }

    public void setModelNorm(String modelNorm) {
        this.modelNorm = modelNorm;
    }

    public Double getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(Double modelPrice) {
        this.modelPrice = modelPrice;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelNo='" + modelNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", modelType='" + modelType + '\'' +
                ", modelNorm='" + modelNorm + '\'' +
                ", modelPrice=" + modelPrice +
                '}';
    }
}
