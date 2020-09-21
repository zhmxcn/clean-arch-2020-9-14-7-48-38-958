package com.thoughtworks.cleanarch;

import javax.xml.validation.SchemaFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Args {
    private List<Arg> argList = new ArrayList<>();
    private String args;

    public Args(String args) throws Exception {
        this.args = args;
        this.argList = parseCommand(args);
    }

    public List<Arg> parseCommand(String command) throws Exception {
        List<String> Args = splitArgs(command);
        for(String Arg: Args ){
            Arg arg = parseArg(Arg);
            checkRepeatFlag(argList,arg);
            argList.add(arg);
        }
        return argList;
    }

    private Arg parseArg(String inputArg) throws Exception {
        try {
            return Arg.to(Arrays.asList(inputArg.split(" ")));
        }catch (Exception e){
            return null;
        }
    }

    private void checkRepeatFlag(List<Arg> argList, Arg arg) throws Exception {
        for (Arg arg1:argList){
            checkFlag(arg1,arg);
        }
    }
    private void checkFlag(Arg arg1,Arg arg) throws Exception {
        if(arg1.getFlag().equals(arg.getFlag())){
            throw new Exception("不允许输入重复flag");
        }
    }

    private List<String> splitArgs( String args){
        return  Arrays.stream(args.split("-"))
                .filter(p->p.length()!=0)
                .collect(Collectors.toList());
    }

    public List<Arg> getArgList() {
        return argList;
    }

}
