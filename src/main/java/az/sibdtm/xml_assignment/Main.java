package az.sibdtm.xml_assignment;

import javax.xml.bind.JAXB;

import java.math.BigDecimal;
import java.math.MathContext;;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));
        LocalDate date = LocalDate.now();
        String url = "https://www.cbar.az/currencies/" + date.format(DateTimeFormatter.ofPattern("dd.MM.YYYY")) + ".xml";
        List<ValType> valTypes = xmlToObject(url);
        List<Valute> allValutes = new ArrayList<>();
        valTypes.forEach(valType -> allValutes.addAll(valType.getValute()));
        System.out.println("Valute type : ");
        valTypes.stream().forEach(valType -> System.out.print(valType.getValType() + "\n"));
        System.out.print("\n input Valute type: ");
        String type = scanner.nextLine();
        System.out.println("valute ");
        valTypes.stream()
                .filter(valType -> valType.
                        getValType()
                        .equals(type))
                .forEach(valType -> valType
                        .getValute()
                        .stream()
                        .forEach(valute -> System.out.println(valute.
                                getNominal() + " "
                                + valute.getName() + " "
                                + valute.getCode() + " "
                                + valute.getValue())));
        System.out.print("input valute code : ");
        String valuteCode = scanner.next();
        Valute valute = allValutes
                .stream()
                .filter(valute1 -> valute1
                        .getCode()
                        .equals(valuteCode))
                .collect(Collectors.toList()).get(0);

        if(type.equals("Bank metalları")){
            System.out.print("kütlə qramla : ");
            BigDecimal bigDecimal =scanner.nextBigDecimal();
           BigDecimal bigDecimal1=bigDecimal.divide(BigDecimal.valueOf(33), MathContext.DECIMAL128);

            System.out.println(bigDecimal + "qr "+bigDecimal1+" "+valute.getNominal().substring(1)+" " + valute.getCode() + " = " + valute.getValue().multiply(bigDecimal1)+" AZN");

        }
        else if(type.equals("Xarici valyutalar")){
            System.out.print("mebleğ : ");
            BigDecimal decimal = scanner.nextBigDecimal();
            BigDecimal decimal1=decimal.divide(BigDecimal.valueOf(Long.parseLong(valute.getNominal())),MathContext.DECIMAL128);
            System.out.println(decimal + " " + valute.getCode() + " = " + valute.getValue().multiply(decimal1)+" AZN");
        }


    }

    public static List<ValType> xmlToObject(String url) {

        try {
            var xmlUrl = new URL(url);
            ValCurs valCurs = JAXB.unmarshal(xmlUrl, ValCurs.class);
            return valCurs.getValTypes().stream().collect(Collectors.toList());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("");
        }


    }


}
