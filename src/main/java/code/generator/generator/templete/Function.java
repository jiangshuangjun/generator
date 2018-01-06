package code.generator.generator.templete;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FUNCTION")
public class Function {

    @XmlAttribute(name = "NAME")
    private String name;

    @XmlAttribute(name = "INDEX")
    private Integer index;

    @XmlAttribute(name = "BLANK_NUM")
    private Integer blankNum;

    @XmlAttribute(name = "RETURN_TYPE")
    private String returnType;

    @XmlAttribute(name = "PARAMS_TYPE")
    private String paramsTypes;

    @XmlElement(name = "FUNCTION_BODY")
    private List<FunctionBody> functionBodys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getBlankNum() {
        return blankNum;
    }

    public void setBlankNum(Integer blankNum) {
        this.blankNum = blankNum;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getParamsTypes() {
        return paramsTypes;
    }

    public void setParamsTypes(String paramsTypes) {
        this.paramsTypes = paramsTypes;
    }

    public List<FunctionBody> getFunctionBodys() {
        return functionBodys;
    }

    public void setFunctionBodys(List<FunctionBody> functionBodys) {
        this.functionBodys = functionBodys;
    }
}
