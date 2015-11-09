package com.airhacks;

import javax.enterprise.inject.Model;

/**
 *
 * @author airhacks.com
 */
@Model
public class Index {

    private String input;
    private String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Object ok() {
        this.output = this.input;
        System.out.println("this.output = " + this.output);
        return null;
    }

}
