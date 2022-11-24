package homeWork.LR3.UtilXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataNodeConfig {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private double lengthWay;

    public DataNodeConfig() {

    }

    public DataNodeConfig(String name, double lengthWay) {
        this.name = name;
        this.lengthWay = lengthWay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLengthWay() {
        return lengthWay;
    }

    public void setLengthWay(double lengthWay) {
        this.lengthWay = lengthWay;
    }
}
