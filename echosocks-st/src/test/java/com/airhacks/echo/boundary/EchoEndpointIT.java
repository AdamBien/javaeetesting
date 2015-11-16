package com.airhacks.echo.boundary;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class EchoEndpointIT {

    private Session session;
    private MessageHandler messageHandler;

    @Before
    public void init() throws URISyntaxException, DeploymentException, IOException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = new URI("ws://localhost:8080/echosocks/echo");
        this.session = container.connectToServer(new Endpoint() {
            @Override
            public void onOpen(Session session, EndpointConfig config) {
            }
        }, uri);

        this.messageHandler = new MessageHandler();
        this.session.addMessageHandler(String.class, this.messageHandler);
    }

    @Test
    public void echo() {
        String expected = "duke";
        this.session.getAsyncRemote().sendText(expected);
        String actual = this.messageHandler.getMessage();
        assertThat(actual, is("+" + expected));
    }

}
