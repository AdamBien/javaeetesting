package com.airhacks.calculator.boundary;

import javax.ejb.Stateless;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class Calculator {

    public int multiply(int a, int b) {
        return a * b;
    }

}
