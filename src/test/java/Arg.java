import javax.xml.validation.SchemaFactory;

public class Arg {
    private String flag;
    private Object value;
    private String type;

    public Arg(String flag, Object value, String type) {
        this.flag = flag;
        this.value = value;
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public Object getValue() {
        return value;
    }
}
