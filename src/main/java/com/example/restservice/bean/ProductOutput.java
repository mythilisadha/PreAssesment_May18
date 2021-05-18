package com.example.restservice.bean;

public class ProductOutput {
    String productId;
    String productName;
    String unitOfMeasure;
    String Status;

    public ProductOutput(String productId, String productName, String unitOfMeasure) {
        this.productId = productId;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ProductOutput() {}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
