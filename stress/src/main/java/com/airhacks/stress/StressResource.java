package com.airhacks.stress;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("stress")
@Stateless
public class StressResource {

    @Inject
    StressManager sm;

    @GET
    public String stress() {
        return sm.stress();
    }

}
