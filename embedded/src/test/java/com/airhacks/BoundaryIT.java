package com.airhacks;

import java.util.logging.Logger;
import javax.inject.Inject;
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
public class BoundaryIT {

    @Inject
    Boundary boundary;

    @Deployment
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class).
                addClasses(LoggerProducer.class,
                        Boundary.class,
                        Control.class,
                        Logger.class).
                addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void boundaryWithoutPlugins() {
        String expected = "perfect day";
        String actual = boundary.greeting();
        assertThat(actual, is(expected));
    }

}
