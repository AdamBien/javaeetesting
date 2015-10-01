package com.airhacks.hello.business.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author airhacks.com
 */
@Table(name = "T_ORDER")
@Entity
public class Order {

    @Id
    @GeneratedValue
    private long id;
    private String trackingNumber;

    public Order(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Order() {
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

}
