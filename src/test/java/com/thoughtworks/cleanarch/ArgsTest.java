package com.thoughtworks.cleanarch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArgsTest {

    @Test
    public void should_return_boolean_0_when_input_no_value() throws Exception {
        String inputCommand = "-l  -p  -d ";

        Args args = new Args(inputCommand);
        List<Arg> argList = args.getArgList();

        List<Arg> targetArgs = new ArrayList<Arg>();
        targetArgs.add(new Arg("l", "false", "boolean"));
        targetArgs.add(new Arg("p", "0", "int"));
        targetArgs.add(new Arg("d", "", "string"));

        assertEquals(targetArgs.get(0),argList.get(0));
        assertEquals(targetArgs.get(1),argList.get(1));
        assertEquals(targetArgs.get(2),argList.get(2));
    }

}