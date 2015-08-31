package com.airhacks;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNoException;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class AssumeTest {

    @Test
    public void assumeNoExceptionDemonstration() {
        try {
            throw new IllegalStateException("internet not available today");
        } catch (Exception ex) {
            assumeNoException(ex);
        }

        fail("should not arrive here");
    }
}
