package com.airhacks.mon.business.reporting.boundary;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Singleton
@Path("snapshots")
public class SnapshotsResource {

    ConcurrentHashMap<String, JsonObject> noSQLDB;

    @PostConstruct
    public void initialize() {
        this.noSQLDB = new ConcurrentHashMap<>();
    }

    @GET
    @Path("{id}")
    public JsonObject find(@PathParam("id") String id) {
        return noSQLDB.get(id);
    }

    @POST
    public Response save(JsonObject payload, @Context UriInfo info) {
        String key = UUID.randomUUID().toString();
        this.noSQLDB.put(key, payload);
        URI uri = info.getAbsolutePathBuilder().
                path("/" + key).
                build();
        return Response.created(uri).build();
    }

}
