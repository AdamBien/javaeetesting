package com.airhacks.hello.business.order.boundary;

import com.airhacks.hello.business.order.control.LegacyAuthenticator;
import com.airhacks.hello.business.order.control.OrderHistory;
import com.airhacks.hello.business.order.control.PaymentProcessor;
import com.airhacks.hello.business.order.entity.Order;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Matchers.argThat;
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
        this.cut.history = mock(OrderHistory.class);
    }

    @Test
    public void successfulOrder() {
        when(this.cut.authenticator.authenticate()).thenReturn(true);
        final String expected = "42";
        this.cut.order(expected);
        verify(this.cut.paymentProcessor).pay();
        verify(this.cut.history).save(argThat(new BaseMatcher<Order>() {

            @Override
            public boolean matches(Object item) {
                if (!(item instanceof Order)) {
                    return false;
                }
                Order order = (Order) item;
                return !expected.equalsIgnoreCase(order.getTrackingNumber());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Should be: " + expected);
            }
        }));
    }

    @Test(expected = IllegalStateException.class)
    public void invaliduser() {
        when(this.cut.authenticator.authenticate()).thenReturn(false);
        this.cut.order("42");
    }

}
