package com.thoughtworks.cleanarch;

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
            checkFlag(argList,arg);
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

    private void checkFlag(List<Arg> argList, Arg arg) throws Exception {
        for (Arg arg1:argList){
            if(arg1.getFlag().equals(arg.getFlag())){
                throw new Exception("不允许输入相同flag");
            }
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
