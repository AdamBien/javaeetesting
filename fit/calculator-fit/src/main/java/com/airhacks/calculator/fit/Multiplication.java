package com.airhacks.calculator.fit;

import fit.ColumnFixture;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author airhacks.com
 */
public class Multiplication extends ColumnFixture {

    public int a;
    public int b;

    private WebTarget tut;

    public Multiplication() {
        Client client = ClientBuilder.newClient();
        this.tut = client.target("http://localhost:8080/calculator/resources/calculations/multiplication/{a}mult{b}");
    }

    public int multiplication() {
        String result = this.tut.resolveTemplate("a", a).
                resolveTemplate("b", b).
                request().
                get(String.class);
        return Integer.parseInt(result);
    }

}
