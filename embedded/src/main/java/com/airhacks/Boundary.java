package com.airhacks;

import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class Boundary {

    @Inject
    Control control;

    @Inject
    Logger LOG;

    public String greeting() {
        LOG.info("about to greet");
        return this.control.message() + " day";
    }

}
