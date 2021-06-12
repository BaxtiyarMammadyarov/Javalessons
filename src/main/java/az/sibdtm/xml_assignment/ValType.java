package az.sibdtm.xml_assignment;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "ValType")
public class ValType {
    private  String valType;
    private List<Valute> valute;

    public ValType() {
    }

    public ValType(String valType, List<Valute> valute) {
        this.valType = valType;
        this.valute = valute;
    }
@XmlAttribute(name = "Type")
    public String getValType() {
        return valType;
    }

    public void setValType(String valType) {
        this.valType = valType;
    }
@XmlElement(name = "Valute")
    public List<Valute> getValute() {
        return valute;
    }

    public void setValute(List<Valute> valute) {
        this.valute = valute;
    }

    @Override
    public String toString() {
        return "ValType{" +
                "valType='" + valType + '\'' +
                ", valute=" + valute +
                '}';
    }
}

