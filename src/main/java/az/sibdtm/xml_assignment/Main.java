package az.sibdtm.xml_assignment;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        LocalDate date = LocalDate.now();
        String url = "https://www.cbar.az/currencies/" + date.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")) + ".xml";
        Scanner scanner = new Scanner((System.in));
        List<ValType> valTypes = xmlToObject(url).getValTypes().stream().collect(Collectors.toList());
        System.out.println("Valute type : ");
        valTypes.stream().forEach(valType -> System.out.print(valType.getValType() + "\n"));
        System.out.print("\ninput Valute type: ");
        String type = scanner.nextLine();
        ValType valType = valTypes
                .stream()
                .filter(valType1 -> valType1.
                        getValType().
                        equals(type))
                .collect(Collectors.toList())
                .get(0);
        System.out.println();

        List<Valute> valuteList = valType.getValute().stream().collect(Collectors.toList());
        System.out.println("valute code:");
        valuteList
                .forEach(valute ->
                        System.out.print(valute.getNominal() +
                                " : " + valute.getName() +
                                " : " + valute.getCode() +
                                ":" + valute.getValue() + " AZN\n"));
        System.out.print("input valute code : ");

        String valuteCode = scanner.next();
        if (type.equals("Bank metalları")) {
            System.out.print("kütlə qramla : ");
            BigDecimal nominal = scanner.nextBigDecimal();

            Valute valute = valuteList.stream().filter(valute1 -> valute1.getCode().equals(valuteCode)).collect(Collectors.toList()).get(0);
            System.out.println(nominal + " qr " + valuteCode + " = " + valute.getValue().multiply(nominal).divide(BigDecimal.valueOf(33l)));
        } else if (type.equals("Xarici valyutalar")) {
            Valute valute = valuteList.stream().filter(valute1 -> valute1.getCode().equals(valuteCode)).collect(Collectors.toList()).get(0);
            System.out.print("mebleğ : ");
            BigDecimal decimal = scanner.nextBigDecimal().divide(BigDecimal.valueOf(Long.parseLong(valute.getNominal())));
            System.out.println(decimal + " " + valute.getCode() + " = " + valute.getValue().multiply(decimal));
        }
    }


    public static ValCurs xmlToObject(String url) {

        try {
            var xmlUrl = new URL(url);
            JAXBContext context = JAXBContext.newInstance(ValCurs.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ValCurs valCurs = JAXB.unmarshal(xmlUrl, ValCurs.class);
            return valCurs;
        } catch (JAXBException | MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        }

    }

}
