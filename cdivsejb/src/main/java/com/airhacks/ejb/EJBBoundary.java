package com.airhacks.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class EJBBoundary {

    @Inject
    EJBControl control;

    public String message() {
        return this.control.message();
    }

}
