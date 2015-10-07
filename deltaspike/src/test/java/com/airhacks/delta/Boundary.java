package com.airhacks.delta;

import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class Boundary {

    @Inject
    Control control;

    public String greeting() {
        return this.control.message() + " day";
    }

}
