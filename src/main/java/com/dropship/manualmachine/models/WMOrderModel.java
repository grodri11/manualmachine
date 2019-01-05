package com.dropship.manualmachine.models;

import com.dropship.manualmachine.ParserObject;

public class WMOrderModel implements ParserObject {

    private String date;
    private String orderNumber;
    private String nameAddress;
    private String basePrice;
    private String shipping;
    private String orderTotal;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "WMOrderModel{" +
                "date='" + date + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", nameAddress='" + nameAddress + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", shipping='" + shipping + '\'' +
                ", orderTotal='" + orderTotal + '\'' +
                '}';
    }
}
