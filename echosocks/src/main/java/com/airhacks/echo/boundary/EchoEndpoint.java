package com.airhacks.echo.boundary;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author airhacks.com
 */
@ServerEndpoint("/echo")
public class EchoEndpoint {

    private Session session;

    @OnOpen
    public void open(Session session) {
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        this.session.getAsyncRemote().sendText("+" + message);
    }

}
