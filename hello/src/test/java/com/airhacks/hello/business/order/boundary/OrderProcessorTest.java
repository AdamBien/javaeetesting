package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;
import com.airhacks.hello.business.order.control.PaymentProcessor;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author airhacks.com
 */
public class OrderProcessorTest {

    OrderProcessor cut;

    @Before
    public void init() {
        this.cut = new OrderProcessor();
        this.cut.paymentProcessor = mock(PaymentProcessor.class);
        this.cut.authenticator = mock(LegacyAuthenticator.class);
    }

    @Test
    public void successfulOrder() {
        when(this.cut.authenticator.authenticate()).thenReturn(true);
        this.cut.order();
        verify(this.cut.paymentProcessor).pay();
    }

    @Test(expected = IllegalStateException.class)
    public void invaliduser() {
        when(this.cut.authenticator.authenticate()).thenReturn(false);
        this.cut.order();
    }

}
