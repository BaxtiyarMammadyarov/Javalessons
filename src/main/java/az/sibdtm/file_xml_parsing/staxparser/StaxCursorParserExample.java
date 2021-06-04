//package az.sibdtm.file_xml_parsing.staxparser;
//
//import az.sibdtm.file_xml_parsing.Address;
//import az.sibdtm.file_xml_parsing.Student;
//
//import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.XMLStreamReader;
//import javax.xml.stream.events.Characters;
//import javax.xml.stream.events.XMLEvent;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StaxCursorParserExample {
//    private static final String xmlfile = "C:\\Users\\Baxtiyar\\Desktop\\student.xml";
//
//    public static void main(String[] args) {
//
//        System.out.println(parserXmlStaxCursor(new File(xmlfile)));
//
//    }
//
//    public static List<Student> parserXmlStaxCursor(File file){
//        XMLInputFactory xmlInputFactory=XMLInputFactory.newInstance();
//        List<Student>list=new ArrayList<>();
//        Student student = null;
//        Address address;
//        try {
//            XMLStreamReader xmlStreamReader=xmlInputFactory.createXMLStreamReader(new FileInputStream(file));
//            while (xmlStreamReader.hasNext()){
//                int type=xmlStreamReader.next();
//                if(type== XMLEvent.START_ELEMENT){
//                    student=new Student();
//
//                    switch (xmlStreamReader.getName().getLocalPart()){
//                        case "student":
//                            student.setId(Integer.parseInt(xmlStreamReader.getAttributeValue(null,"id")));
//                            break;
//                        case "name":
//                            type=xmlStreamReader.next();
//                            if(type==XMLEvent.CHARACTERS){
//                                student.setName(xmlStreamReader.getText());
//                            }
//                            break;
//                        case "surname":
//                            type=xmlStreamReader.next();
//                            if(type==XMLEvent.CHARACTERS){
//                                student.setSurname(xmlStreamReader.getText());
//                            }
//                            break;
//                        case "age":
//                            type=xmlStreamReader.next();
//                            if(type==XMLEvent.CHARACTERS){
//                                student.setAge(Integer.parseInt(xmlStreamReader.getText()));
//                            }
//                            break;
//                        case "gender":
//                            type=xmlStreamReader.next();
//                            if(type==XMLEvent.CHARACTERS){
//                                student.setGender(xmlStreamReader.getText());
//                            }
//                            break;
//                        case "city":
//                            type=xmlStreamReader.next();
//                            address=new Address();
//                            if(type==XMLEvent.CHARACTERS){
//                                address.setCity(xmlStreamReader.);
//                            }
//                            break;
//                        case "region":
//                            type=xmlStreamReader.next();
//                            address=new Address();
//                            if(type==XMLEvent.CHARACTERS){
//                                address.setRegion(xmlStreamReader.getText());
//                            }
//                            student.setAddress(address);
//                            break;
//
//                    }
//                }
//                list.add(student);
//            }
//
//        } catch (XMLStreamException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//}
