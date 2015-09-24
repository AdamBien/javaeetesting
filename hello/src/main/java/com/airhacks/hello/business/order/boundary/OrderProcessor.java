package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;
import com.airhacks.hello.business.order.control.PaymentProcessor;
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

    public void order() {
        if (!this.authenticator.authenticate()) {
            throw new IllegalStateException("Not authenticated");
        }
        this.paymentProcessor.pay();
    }

}
