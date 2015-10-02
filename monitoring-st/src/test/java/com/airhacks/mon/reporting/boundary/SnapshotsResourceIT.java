package com.airhacks.mon.reporting.boundary;

import static com.airhacks.rulz.jaxrsclient.HttpMatchers.successful;
import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import javax.json.JsonObject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class SnapshotsResourceIT {

    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/monitoring/resources/snapshots");

    @Test

    public void snapshots() {
        Response response = this.provider.target().request(MediaType.APPLICATION_JSON).get();
        assertThat(response, successful());
        JsonObject result = response.readEntity(JsonObject.class);
        assertNotNull(result);
        System.out.println("result = " + result);

    }

}
