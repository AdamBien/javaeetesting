package com.airhacks.junit.hello;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author airhacks.com
 */
public class SystemOutRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                System.out.println("before----");
                base.evaluate();
                System.out.println("after---" + description.getClassName() + "-" + description.getMethodName() + " tested !");
            }
        };
    }

}
