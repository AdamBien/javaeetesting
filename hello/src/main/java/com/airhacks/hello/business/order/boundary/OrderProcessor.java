package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;
import com.airhacks.hello.business.order.control.OrderHistory;
import com.airhacks.hello.business.order.control.PaymentProcessor;
import com.airhacks.hello.business.order.entity.Order;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class OrderProcessor {

    @Inject
    LegacyAuthenticator authenticator;
    @Inject
    PaymentProcessor paymentProcessor;

    @Inject
    OrderHistory history;

    public void order(String orderid) {
        if (!this.authenticator.authenticate()) {
            throw new IllegalStateException("Not authenticated");
        }
        Order order = new Order(orderid);
        this.paymentProcessor.pay();
        this.history.save(order);
    }

}
