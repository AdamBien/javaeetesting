package com.airhacks.mon.reporting.boundary;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author airhacks.com
 */
public class JAXRSClient implements TestRule {

    private Client client;
    private WebTarget tut;

    private JAXRSClient(String uri) {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target(uri);
    }

    public static JAXRSClient target(String uri) {
        return new JAXRSClient(uri);
    }

    public WebTarget tut() {
        return this.tut;
    }

    public Client client() {
        return this.client;
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                base.evaluate();
            }
        };
    }

}
