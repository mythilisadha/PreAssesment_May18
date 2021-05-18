package com.example.restservice.bean;

import java.util.Date;

public class Order {
    String productId;
    Double qty;
    String orderId;

    public Order(String orderId, String productId, Double qty) {
        this.productId = productId;
        this.qty = qty;
        this.orderId = orderId;
    }
    public Order() {}

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
