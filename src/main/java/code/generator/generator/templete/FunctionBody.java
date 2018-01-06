package code.generator.generator.templete;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FUNCTION_BODY")
public class FunctionBody {

    @XmlAttribute(name = "INDEX")
    private Integer index;

    @XmlAttribute(name = "BLANK_NUM")
    private Integer blankNum;

    @XmlValue
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
