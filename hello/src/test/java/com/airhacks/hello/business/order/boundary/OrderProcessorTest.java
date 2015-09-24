package com.airhacks.hello.business.order.boundary;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class OrderProcessorTest {

    OrderProcessor cut;

    @Before
    public void init() {
        this.cut = new OrderProcessor();
    }

    @Test
    public void successfulOrder() {
        this.cut.order();
    }

    @Test(expected = IllegalStateException.class)
    public void invaliduser() {
        this.cut.authenticator = new MockAuthenticator();
        this.cut.order();
    }

}
