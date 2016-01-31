package com.airhacks.delta;

import javax.inject.Inject;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author airhacks.com
 */
@RunWith(PropertiesLoaderTestRunner.class)
public class SystemPropertyExposerIT {

    @Inject
    String developer;

    @Test
    public void developerInjection() {
        assertThat(developer, is("duke"));
    }

}
