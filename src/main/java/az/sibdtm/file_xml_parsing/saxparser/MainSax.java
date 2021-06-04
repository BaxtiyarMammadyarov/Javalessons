package az.sibdtm.file_xml_parsing.saxparser;

import az.sibdtm.file_xml_parsing.Student;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainSax {
    private static final String xmlfile = "C:\\Users\\Baxtiyar\\Desktop\\student.xml";

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        try {
            SAXParser saxParser=saxParserFactory.newSAXParser();
            SaxParserExample saxParserExample=new SaxParserExample();
            saxParser.parse(new File(xmlfile),saxParserExample);
            List<Student> list=saxParserExample.getStudents();
            list.forEach(System.out::println);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
