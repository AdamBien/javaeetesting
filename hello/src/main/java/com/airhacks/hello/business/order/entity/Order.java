package com.airhacks.hello.business.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author airhacks.com
 */
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
