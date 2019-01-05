package com.dropship.manualmachine.models;
import com.dropship.manualmachine.ParserObject;
import com.opencsv.bean.CsvToBean;


public class ShippingModel implements ParserObject {

    private String orderedDate;
    private String orderId;
    private String trackingNumber;
    private String courier;
    private String orderTotal;

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public String toString() {
        return "ShippingModel{" +
                "orderedDate='" + orderedDate + '\'' +
                ", orderId='" + orderId + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", courier='" + courier + '\'' +
                ", orderTotal='" + orderTotal + '\'' +
                '}';
    }
}
