package com.airhacks.delta;

import javax.enterprise.inject.Produces;

/**
 *
 * @author airhacks.com
 */
public class SystemPropertyExposer {

    @Produces
    public String expose() {
        return System.getProperty("dev");
    }

}
