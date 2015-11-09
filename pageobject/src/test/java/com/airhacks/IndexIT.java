package com.airhacks;

import static org.hamcrest.CoreMatchers.is;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.InitialPage;
import org.jboss.arquillian.junit.Arquillian;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author airhacks.com
 */
@RunAsClient
@RunWith(Arquillian.class)
public class IndexIT {

    @Drone
    WebDriver browser;

    @Test
    public void copy(@InitialPage IndexPage page) {
        String expected = "duke";
        String actual = page.copy(expected);
        assertThat(actual, is(expected));
    }

}
