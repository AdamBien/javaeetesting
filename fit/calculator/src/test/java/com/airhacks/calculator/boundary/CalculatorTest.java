package com.airhacks.calculator.boundary;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class CalculatorTest {

    Calculator cut;

    @Before
    public void init() {
        this.cut = new Calculator();
    }

    @Test
    public void multiply() {
        final int a = 2;
        final int b = 21;
        int result = this.cut.multiply(a, b);
        System.out.println("multiply = " + result);
        assertThat(result, is(a * b));
    }

}
