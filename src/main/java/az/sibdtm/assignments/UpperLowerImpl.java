package az.sibdtm.assignments;

public class UpperLowerImpl {
    public static void main(String[] args) {
        String str1="HELLO WORLD";
        String str2="hello world";

        System.out.println(str1+" : "+lowerCaseImpl(str1));

        System.out.println(upperCaseImpl(str2+" : "+str2));


    }
    public static String lowerCaseImpl(String str){
        String result ="";
        for (char ch:str.toCharArray()){
            if((ch>64&&ch<92)){
                result+=(char)((int)ch+32);
            }else {
                result+=ch;
            }
        }
        return result;
    }
    public static String upperCaseImpl(String str){
        String result ="";
        for (char ch:str.toCharArray()){
            if((ch>96&&ch<122)){
                result+=(char)((int)ch-32);
            }else {
                result+=ch;
            }
        }
        return result;
    }
}
