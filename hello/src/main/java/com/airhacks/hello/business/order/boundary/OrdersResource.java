package com.airhacks.hello.business.order.boundary;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("orders")
public class OrdersResource {

    @Inject
    OrderProcessor processor;

    @POST
    public void order() {
        processor.order();
    }

}
