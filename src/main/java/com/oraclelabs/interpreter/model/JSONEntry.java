package com.oraclelabs.interpreter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JSONEntry {
    private String instruction;
    private String sessionID;

    public JSONEntry(@JsonProperty("code") String instruction, @JsonProperty("sessionID") String sessionID) {
        this.instruction = instruction;
        this.sessionID = sessionID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getInstruction () {
        return instruction;
    }
}

