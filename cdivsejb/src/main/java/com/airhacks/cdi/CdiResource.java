package com.airhacks.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@RequestScoped
@Path("cdi")
public class CdiResource {

    @Inject
    CdiBoundary boundary;

    @GET
    public String cdi() {
        return boundary.message();
    }

}
