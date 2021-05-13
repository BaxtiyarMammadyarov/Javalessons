package az.sibdtm.assignments;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        try {
            System.out.print("input num1: ");
            int num1=scn.nextInt();
            System.out.print("input num2: ");
            int num2=scn.nextInt();
            int  result=num1/num2;

        }catch (InputMismatchException ex){
            System.out.println(String.format("daxil olan eded integer deyil"));
        }catch (ArithmeticException ex){
            System.out.println(String.format("sifira bolme yoxdur %s",ex.getMessage()));
        }catch (Exception e){
            System.out.println(String.format("xeta bas verdi %s",e.getMessage()));
        }
    }

}
