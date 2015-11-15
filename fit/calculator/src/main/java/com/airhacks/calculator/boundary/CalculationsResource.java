package com.airhacks.calculator.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author airhacks.com
 */
@Path("calculations")
public class CalculationsResource {

    @Inject
    Calculator calculator;

    @GET
    @Path("/multiplication/{a}mult{b}")
    public String multiplication(@PathParam("a") int a, @PathParam("b") int b) {
        return String.valueOf(calculator.multiply(a, b));
    }

}
