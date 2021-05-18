package com.example.restservice.bean;

import java.util.List;

public class OrderOutput {

    Order order;
    List<Shipment> shipment;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Shipment> getShipment() {
        return shipment;
    }

    public void setShipment(List<Shipment> shipment) {
        this.shipment = shipment;
    }
}
