package com.airhacks.cdi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@RequestScoped
public class CdiBoundary {

    @Inject
    CdiControl control;

    public String message() {
        return this.control.message();
    }

}
