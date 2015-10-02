package com.airhacks.mon.business.reporting.boundary;

import javax.json.JsonObject;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class SnapshotsResourceIT extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(SnapshotsResource.class);
    }

    @Test
    public void snapshots() {
        Response response = target("snapshots").request().get();
        assertThat(response.getStatus(), is(200));
        JsonObject result = response.readEntity(JsonObject.class);
        System.out.println("result = " + result);
    }

}
