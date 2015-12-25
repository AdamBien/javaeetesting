package com.airhacks.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("ejb")
public class EJBResource {

    @Inject
    EJBBoundary boundary;

    @GET
    public String cdi() {
        return boundary.message();
    }

}
