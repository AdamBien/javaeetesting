package com.airhacks.jersey;

import javax.inject.Singleton;
import javax.json.Json;
import javax.json.JsonObject;
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
    public JsonObject ms() {
        return Json.createObjectBuilder().
                add("time", System.currentTimeMillis()).
                build();
    }

}
