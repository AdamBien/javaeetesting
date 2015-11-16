package com.airhacks.echo.boundary;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author airhacks.com
 */
public class MessageHandler implements javax.websocket.MessageHandler.Whole<String> {

    private final CountDownLatch messageLatch;

    private String message;

    public MessageHandler() {
        this.messageLatch = new CountDownLatch(1);
    }

    @Override
    public void onMessage(String message) {
        this.message = message;
        this.messageLatch.countDown();
    }

    public String getMessage() {
        try {
            messageLatch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            throw new IllegalStateException(ex);
        }
        return message;
    }

}
