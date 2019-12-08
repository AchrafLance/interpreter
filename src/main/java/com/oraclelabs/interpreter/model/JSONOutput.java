package com.oraclelabs.interpreter.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class JSONOutput {
    private String output;

    public JSONOutput(@JsonProperty("result") String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
}
