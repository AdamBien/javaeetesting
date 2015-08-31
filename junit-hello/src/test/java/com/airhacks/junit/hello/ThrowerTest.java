package com.airhacks.junit.hello;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author airhacks.com
 */
public class ThrowerTest {

    private Thrower cut;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize() {
        this.cut = new Thrower();
    }

    @Test(expected = IllegalStateException.class)
    public void exception() {
        this.cut.throwException();
    }

    @Test
    public void detailedException() {
        try {
            this.cut.throwException();
            fail("Expecting IllegalStateException here");
        } catch (IllegalStateException ex) {
            String message = ex.getMessage();
            assertThat(message, containsString("illegal"));
        }
    }

    @Test
    public void exceptionWithRule() {
        this.thrown.expect(IllegalStateException.class);
        this.thrown.expectMessage(containsString("illegal"));
        this.cut.throwException();

    }

}
