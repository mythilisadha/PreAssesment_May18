package com.example.restservice.bean;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    List<OrdersWithLaunchDate> productList = new ArrayList<>();

    public List<OrdersWithLaunchDate> getProductList() {
        return productList;
    }

    public void setProductList(List<OrdersWithLaunchDate> productList) {
        this.productList = productList;
    }
}
