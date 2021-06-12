package az.sibdtm.xml_assignment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "ValCurs")
public class ValCurs {
    private String date;
    private String name;
    private String description;
    private List<ValType> valTypes;

    public ValCurs() {
    }

    public ValCurs(String date, String name, String description, List<ValType> valTypes) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.valTypes = valTypes;
    }
    @XmlAttribute(name = "Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @XmlAttribute(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name ="Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "ValType")
    public List<ValType> getValTypes() {
        return valTypes;
    }

    public void setValTypes(List<ValType> valTypes) {
        this.valTypes = valTypes;
    }

    @Override
    public String toString() {
        return "ValCurs{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", valTypes=" + valTypes +
                '}';
    }
}
