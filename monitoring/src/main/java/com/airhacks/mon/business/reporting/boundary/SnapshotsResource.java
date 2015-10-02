package com.airhacks.mon.business.reporting.boundary;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("snapshots")
public class SnapshotsResource {

    @GET
    public JsonObject snapshots() {
        return Json.createObjectBuilder().
                add("s1", "fast").
                build();
    }

}
