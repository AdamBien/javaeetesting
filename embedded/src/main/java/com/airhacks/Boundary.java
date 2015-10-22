package com.airhacks;

import java.util.logging.Logger;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class Boundary {

    @Inject
    Instance<Control> control;

    @Inject
    Logger LOG;

    public String greeting() {
        LOG.info("about to greet");
        String prefix = "perfect";
        if (!control.isAmbiguous() && !control.isUnsatisfied()) {
            prefix = this.control.get().message();
        }
        return prefix + " day";
    }

}
