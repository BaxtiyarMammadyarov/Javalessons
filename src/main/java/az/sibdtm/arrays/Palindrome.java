package az.sibdtm.arrays;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("input string: ");
        String str=scanner.next();
        if(checkPalindrome(str))
            System.out.println("--palindromdur--");
        else
            System.out.println("--palindrom deyil--");
    }

    public static char[] createCharArray(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    public static boolean checkPalindrome(String str) {
        char[] chararr = createCharArray(str);
        boolean result = false;
        for (int i = 0; i < chararr.length / 2; i++) {
            if (chararr[i] == chararr[chararr.length - 1 - i]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
