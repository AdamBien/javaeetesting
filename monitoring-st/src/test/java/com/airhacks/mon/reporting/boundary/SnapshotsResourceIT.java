package com.airhacks.mon.reporting.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class SnapshotsResourceIT {

    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/monitoring/resources/snapshots");

    @Test

    public void crud() {
        final String key = "java";
        final String value = "rocks";
        JsonObject payload = Json.createObjectBuilder().
                add(key, value).
                build();

        Response response = provider.target().
                request().
                post(Entity.json(payload));
        assertThat(response.getStatus(), is(201));
        String uri = response.getHeaderString("Location");
        assertNotNull(uri);

        JsonObject result = provider.
                target(uri).
                request(MediaType.APPLICATION_JSON).
                get(JsonObject.class);
        assertNotNull(result);
        assertThat(result.getString(key), is(value));

    }

}
