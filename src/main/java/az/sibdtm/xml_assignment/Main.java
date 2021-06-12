package az.sibdtm.xml_assignment;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        LocalDate date= LocalDate.now();
        ValCurs valCurs=xmlToObject("https://www.cbar.az/currencies/"+date.format(DateTimeFormatter.ofPattern("dd.MM.YYYY"))+".xml");

        Scanner scanner=new Scanner((System.in));
        System.out.print("input Valute type ");
        String val=scanner.next();
        System.out.print("input Valute   ");
        String valute=scanner.next();
        System.out.print("input nominal ");
        String nominal=scanner.next();
        System.out.println("currency exchange valute : " ) ;
        String currencyExchange=scanner.next();






}
    public static ValCurs xmlToObject(String url)  {


        try {
            var xmlUrl=new URL(url);

            JAXBContext context= JAXBContext.newInstance(ValCurs.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();

            ValCurs valCurs= JAXB.unmarshal(url,ValCurs.class);
            System.out.println(valCurs);
            return valCurs;
        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
            throw new  RuntimeException("");
        }

    }

}
