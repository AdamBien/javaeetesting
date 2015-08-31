package com.airhacks;

import com.airhacks.junit.hello.SystemOutRule;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 *
 * @author airhacks.com
 */
public class HelloTest {

    @Rule
    public SystemOutRule rule = new SystemOutRule();

    @Rule
    public Timeout timeout = Timeout.seconds(1);

    @Before
    public void init() {
        System.out.println("Before each test");
    }

    @Test
    public void hello() {
        String result = "hello";
        assertNotNull(result);
        assertThat(result, is("hello"));
    }

    @Test
    public void another() {
        System.out.println("inside another");
    }

    @Test(timeout = 2000)
    public void tooSlow() {
        while (true) {
        }
    }

    @After
    public void destroy() {
        System.out.println("After the test");
    }

}
