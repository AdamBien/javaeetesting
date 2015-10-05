package com.airhacks;

import javax.inject.Inject;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author airhacks.com
 */
@RunWith(Arquillian.class)
public class InjectEmAllIT {

    @Inject
    Boundary boundary;

    @Deployment
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class).
                addClasses(Boundary.class).
                addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void injection() {
        assertNotNull(boundary);
        String expected = "perfect day";
        String greeting = boundary.greeting();
        assertThat(greeting, is(expected));
    }

}
