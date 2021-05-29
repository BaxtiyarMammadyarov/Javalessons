package az.sibdtm.file_xml_parsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxParserExample extends DefaultHandler {

    private StringBuilder stringBuilder =new StringBuilder();


    List<Student> students;
    Student student;
    Address address;


    @Override
    public String toString() {
        return "SaxParserExample{" +
                "students=" + students +
                '}';
    }

    public List<Student> getStudents() {
        return students;
    }


    @Override
    public void startDocument() throws SAXException {
        students=new ArrayList<>();

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);
        if(qName.equalsIgnoreCase("student")){
            student=new Student();
            student.setId(Integer.parseInt(attributes.getValue("id")));

        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        stringBuilder.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("name")){
            student.setName(stringBuilder.toString());
        }
        if(qName.equalsIgnoreCase("surname")){
            student.setSurname(stringBuilder.toString());
        }
        if(qName.equalsIgnoreCase("age")){
            student.setAge(Integer.parseInt(stringBuilder.toString()));
        }
        if(qName.equalsIgnoreCase("gender")){
            student.setGender(stringBuilder.toString());
        }
        if(qName.equalsIgnoreCase("city")){

         address=new Address();
         address.setCity(stringBuilder.toString());
        }
        if(qName.equalsIgnoreCase("region")){
            address.setRegion(stringBuilder.toString());
            student.setAddress(address);
        }
        if(qName.equalsIgnoreCase("student")){

            students.add(student);
        }

    }



    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
