package com.dropship.manualmachine.models;
import com.dropship.manualmachine.ParserObject;
import com.opencsv.bean.CsvToBean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "shippingdata")
public class ShippingModel implements ParserObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingdata_id;

    @Column(name = "date_ordered", nullable = false)
    private String orderedDate;
    @Column(name = "order_id", nullable = false)
    private String orderId;
    @Column(name = "tracking_number", nullable = false)
    private String trackingNumber;
    @Column(name = "courier", nullable = false)
    private String courier;
    @Column(name = "order_total", nullable = false)
    private BigDecimal orderTotal;

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

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = new BigDecimal(orderTotal.substring(1));
    }

    public Long getShippingdata_id() {
        return shippingdata_id;
    }

    public void setShippingdata_id(Long shippingdata_id) {
        this.shippingdata_id = shippingdata_id;
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
