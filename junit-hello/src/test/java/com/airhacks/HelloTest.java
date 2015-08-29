package com.airhacks;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class HelloTest {

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

    @After
    public void destroy() {
        System.out.println("After the test");
    }

}
