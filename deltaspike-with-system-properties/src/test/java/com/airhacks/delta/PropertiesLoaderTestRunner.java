package com.airhacks.delta;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.runners.model.InitializationError;

/**
 *
 * @author airhacks.com
 */
public class PropertiesLoaderTestRunner extends CdiTestRunner {

    static {
        System.setProperty("dev", "duke");
    }

    public PropertiesLoaderTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

}
