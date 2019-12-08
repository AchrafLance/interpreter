package com.oraclelabs.interpreter.controller;

import com.oraclelabs.interpreter.model.JSONEntry;
import com.oraclelabs.interpreter.model.JSONOutput;
import com.oraclelabs.interpreter.service.EntryService;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/execute")
@RestController
public class EntryController {
    private final EntryService entryService;

    @Autowired // injecting the CodeService in the codeController's instructor
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }


    @GetMapping
    public JSONOutput execute(@RequestBody JSONEntry jsonEntry){
        String sessionID = jsonEntry.getSessionID();
        String instruction = jsonEntry.getInstruction();
        PythonInterpreter python = entryService.getInterpreter(sessionID);
        return entryService.pythonExec(instruction, python);
    }

}