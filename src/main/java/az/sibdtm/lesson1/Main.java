package az.sibdtm.lesson1;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn=new Scanner(System.in);

        System.out.print("input number1= ");
        double number1=scn.nextDouble();
        System.out.print("input operator: ");
        String operator=scn.next();
        System.out.print("input number2= ");
        double number2=scn.nextDouble();

        System.out.println("answer = "+ operators(operator,number1,number2));



    }

    public static Double operators(String operator,double number1,double number2){
      Double result = null;
        switch (operator){
            case "+":
                result=number1+number2;
                break;
            case "-":
                result=number1-number2;
                break;
            case "*":
                result=number1*number2;
                break;
            case "/":
                if(number2!=0) {
                    result=number1/number2;
                break;
                }
                else System.out.println("Sifira bolme yoxdur");break;
            case "%":
                result=(number1*number2)/100;
                break;
            case "pow":
                result=Math.pow(number1,number2);
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }



    return result;}


}
