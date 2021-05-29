package az.sibdtm.file_xml_parsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlDomParserExample {
    private static final String xmlfile = "C:\\Users\\Baxtiyar\\Desktop\\student.xml";

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            builderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlfile));
            document.getDocumentElement().normalize();
            NodeList list = document.getElementsByTagName("student");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                Student student = new Student();
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    student.setId(Integer.parseInt(element.getAttribute("id")));

                    student.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    student.setSurname(element.getElementsByTagName("surname").item(0).getTextContent());
                    student.setAge(Integer.parseInt(element.getElementsByTagName("age").item(0).getTextContent()));
                    student.setGender(element.getElementsByTagName("gender").item(0).getTextContent());

                    NodeList nodeList =element.getElementsByTagName("address");
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Address address=new Address();
                        Node node1=nodeList.item(j);

                        if(node1.getNodeType()==Node.ELEMENT_NODE){

                            address.setCity(((Element) node).getElementsByTagName("city").item(0).getTextContent());
                            address.setRegion(((Element) node).getElementsByTagName("region").item(0).getTextContent());
                            student.setAddress(address);
                        }

                    }

                }
                studentList.add(student);
            }


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        System.out.println(studentList);

    }
}
