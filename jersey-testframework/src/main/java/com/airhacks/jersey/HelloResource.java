package com.airhacks.jersey;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Singleton
@Path("hello")
public class HelloResource {

    @GET
    public String ms() {
        return " " + System.currentTimeMillis();
    }

}
