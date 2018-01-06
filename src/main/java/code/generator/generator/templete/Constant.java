package code.generator.generator.templete;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CONSTANT")
public class Constant {

    @XmlAttribute(name = "INDEX")
    private Integer index;

    @XmlAttribute(name = "BLANK_NUM")
    private Integer blankNum;

    @XmlAttribute(name = "TYPE")
    private String type;

    @XmlElement(name = "KEY")
    private String key;

    @XmlElement(name = "VALUE")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
