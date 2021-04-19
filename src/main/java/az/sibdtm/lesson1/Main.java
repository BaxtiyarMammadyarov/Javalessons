package az.sibdtm.lesson1;



import java.util.Scanner;

public class Main  {


    public static void main(String[] args) {

        Scanner scn=new Scanner(System.in);

        double number2,number1;
        System.out.println("Operatorlar:\n " +
                           "'+':toplam, '-':çixma, '*':vurma, '/':bölmə, \n" +
                           " '%':faiz ,'pow':qüvvət ,'sqrt':kvd kök,'abs':modul \n programi bağlamaq:'exit' ");
        do {
            System.out.print("input firstnumber= ");
             number1 = scn.nextDouble();
            System.out.print("input operator: ");
            String operator = scn.next();
            if(operator.equals("sqrt")||operator.equals("abs")){
                number2=0.0;
            }else{
                System.out.print("input secondnumber= ");
                number2 = scn.nextDouble();
            }
            printResult(operator,number1,number2);
            System.out.println("programı sonlandırmaq üçün 'exit' konamdsini daxil edin \n əks halda hər hansi bir simvol daxil et");
            System.out.print("input comand : ");
            String comand=scn.next();
            if(comand.equals("exit")) break;
        }while(true);
    }




     public static void printResult(String operator,double number1,double number2){
     String result =  operators(operator, number1, number2).toString();
       if(result.length()-result.indexOf(".")==2&&result.charAt(result.length()-1)=='0'){
           result= result.substring(0,result.length()-2);
       }
       if(number2==0){
            result=operator+"("+number1+") "+" = "+result;
       }else result=number1+" "+operator+" "+number2+" = "+result;
         System.out.println(result);
    }


    public static Double operators(String operator,double number1,double number2){
      double result ;
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
                else { System.out.println("Sifira bolme yoxdur");
                    result=0.0;
                    break;}
            case "%":
                result=(number1*number2)/100;
                break;
            case "pow":
                result=Math.pow(number1,number2);
                break;
            case "sqrt":
                result=Math.sqrt(number1);
                break;
            case "abs":
                result=Math.abs(number1);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
    return result;
    }
}
