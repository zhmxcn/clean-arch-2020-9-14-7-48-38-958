package com.thoughtworks.cleanarch;

import javax.xml.validation.SchemaFactory;
import java.util.List;

public class Arg {
    private String flag;
    private Object value;
    private String type;

    public Arg(String flag, Object value, String type) {
        this.flag = flag;
        this.value = value;
        this.type = type;
    }

    public static Arg to(List<String> argList) {
        String flag = (String) argList.get(0);
        Schema schema = null;
        switch(flag){
            case "l" :
                schema = new Schema(flag,"boolean",false);
                break;
            case "p" :
                schema = new Schema(flag,"int",0);
                break;
            case "d" :
                schema = new Schema(flag,"String","");
                break;
        }
        return new Arg((String) argList.get(0),argList.get(1),schema.getValueType());
    }

    public String getFlag() {
        return flag;
    }

    public Object getValue() {
        return value;
    }
}
