package com.airhacks;

import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
public class LoggerTestSupport {

    @Inject
    Logger LOG;

    public Logger getLog() {
        return LOG;
    }

}
