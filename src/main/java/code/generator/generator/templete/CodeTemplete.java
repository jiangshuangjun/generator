package code.generator.generator.templete;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CODE_TEMPLETE")
public class CodeTemplete {

    @XmlAttribute(name = "SUPER_NAME")
    private String superName;

    @XmlAttribute(name = "CLASS_NAME")
    private String className;

    @XmlElementWrapper(name = "CONSTANTS")
    @XmlElement(name = "CONSTANT")
    private List<Constant> constants = new ArrayList<Constant>();

    @XmlElementWrapper(name = "FIELDS")
    @XmlElement(name = "FIELD")
    private List<Field> fields = new ArrayList<Field>();

    @XmlElementWrapper(name = "FUNCTIONS")
    @XmlElement(name = "FUNCTION")
    private List<Function> functions = new ArrayList<Function>();

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Constant> getConstants() {
        return constants;
    }

    public void setConstants(List<Constant> constants) {
        this.constants = constants;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }
}
