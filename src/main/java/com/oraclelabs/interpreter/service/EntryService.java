package com.oraclelabs.interpreter.service;

import com.oraclelabs.interpreter.model.JSONOutput;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

@Service // @Service for dependency injection
public class EntryService {
    private HashMap<String, PythonInterpreter> InterpreterMap = new HashMap();

    /*
    PythonInterpreter method is going create a new python sub-process each time it gets a new sessionID,
    while also returning python sub-process for created sessions
     */

    public PythonInterpreter getInterpreter(String sessionID) {
        PythonInterpreter python;

        if (InterpreterMap.containsKey(sessionID)) {
            return InterpreterMap.get(sessionID);
        } else {
            python = new PythonInterpreter();
            InterpreterMap.put(sessionID, python);
            return python;
        }
    }

    /*
    pythonExec method is going to execute the instruction parsed from the JSONEntry and return it as JSONOutput
     */

    public JSONOutput pythonExec(String jsonEntry, PythonInterpreter python)  {

        JSONOutput jsonOutput;
        String result;
        String[] arr = jsonEntry.split(" ", 2);
        String language = arr[0].substring(1); // using substring to delete the '%' at the start of the instruction
        String instruction = arr[1];


        if (language.equalsIgnoreCase("python")) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream(); /* output stream to capture the results from
                                                                           the python interpreter*/
            python.setOut(stream);

            try {
                python.exec(instruction);
                result = stream.toString();
                int n = result.length();
                if(n==0){
                    jsonOutput = new JSONOutput(result);
                }else {
                    jsonOutput = new JSONOutput(result.substring(0,n-2));  /* substring to delete a '/r/n' that keeps showing at the
                                                                              end JSON results */
                }

                return jsonOutput;

            }catch(Exception e){
                jsonOutput = new JSONOutput("Error: " + e.toString()); // handling errors that might occur: syntax, arithmetic...etc.
                return jsonOutput;
            }
        }

        else{
            jsonOutput = new JSONOutput("Unknown language, please write python code only");
            return jsonOutput;
        }

    }



}