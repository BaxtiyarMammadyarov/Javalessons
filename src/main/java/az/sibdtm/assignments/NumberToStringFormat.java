package az.sibdtm.assignments;

public class NumberToStringFormat {
    public static void main(String[] args) {
        System.out.println(numberToStringFormat(15));
        System.out.println(numberToStringFormat(100));
        System.out.println(numberToStringFormat(110));
        System.out.println(numberToStringFormat(810));
        System.out.println(numberToStringFormat(999));
        System.out.println(numberToStringFormat(1000));
        System.out.println(numberToStringFormat(1099));
        System.out.println(numberToStringFormat(1999));
        System.out.println(numberToStringFormat(9999));
        System.out.println(numberToStringFormat(29999));
        System.out.println(numberToStringFormat(359999));
        System.out.println(numberToStringFormat(1359999));
        System.out.println(numberToStringFormat(2359999));
        System.out.println(numberToStringFormat(24359999));
        System.out.println(numberToStringFormat(258359999));
        System.out.println(numberToStringFormat(1258359999));
        System.out.println(numberToStringFormat(1258359999));


    }
    public static String numberToStringFormat(Integer number) {//120000000
        String str = Integer.toString(number);
        if (str.length() == 1) {
            return digitToString(str.charAt(0));
        } else if (str.length() ==2) {
            return decimalNumber(str);
        } else if (str.length() == 3) {
            return hundredNumbers(str);
        } else if (str.length() > 3 && str.length() < 7) {
            return thousandNumber(str);
        }else if (str.length() > 6 && str.length() < 10) {
            return millionNumber(str);
        }else if(str.length() > 9 && str.length() < 13){
            return billionNumber(str);
        }
        else return "";
    }
    public static String digitToString(char digit) {
        String result ;
        switch (digit) {
            case '1':
                result = "bir";
                break;
            case '2':
                result = "iki";
                break;
            case '3':
                result = "Üç";
                break;
            case '4':
                result = "dörd";
                break;
            case '5':
                result = "beş";
                break;
            case '6':
                result = "altı";
                break;
            case '7':
                result = "yeddi";
                break;
            case '8':
                result = "səkkiz";
                break;
            case '9':
                result = "doqquz";
                break;
            case '0':
                result = "";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }

    public static String decimal(char str) {
        String result = "";
        switch (str) {
            case '1':
                result = "on";
                break;
            case '2':
                result = "iyirmi";
                break;
            case '3':
                result = "otuz";
                break;
            case '4':
                result = "qrıx";
                break;
            case '5':
                result = "əlli";
                break;
            case '6':
                result = "altımış";
                break;
            case '7':
                result = "yetmiş";
                break;
            case '8':
                result = "səksən";
                break;
            case '9':
                result = "doxsan";
                break;
            case '0':
                result = "";
                break;
            default:
                result = "";
                break;

        }
        return result;
    }
    public static String decimalNumber(String str){
        return decimal(str.charAt(0))+" "+digitToString(str.charAt(1));
    }

    public static String hundredNumbers(String str) {
        if (str.substring(0, 1).equals("0")) {
            return   decimalNumber(str.substring(1));
        } else if (str.substring(0, 1).equals("1")) {
            return  "yüz " + decimalNumber(str.substring(1));
        } else {
            return digitToString(str.charAt(0)) +
                    " yüz " + decimalNumber(str.substring(1));
        }
    }
    public static String thousandNumber(String str){
        String newstr="";
        if(str.length()==4&&str.substring(0,1).equals("1")){
            newstr+="min "+ hundredNumbers(str.substring(str.length()-3));
        }else if(str.substring(0,str.length()-3).length()==1) {
            newstr +=digitToString(str.charAt(0)) + " min  " + hundredNumbers(str.substring(str.length() - 3));
        }else if(str.substring(0,str.length()-3).length()==2) {
            newstr +=decimalNumber(str.substring(0,str.length()-3)) + " min " + hundredNumbers(str.substring(str.length() - 3));
        }else if(str.substring(0,str.length()-3).length()==3) {
            newstr +=hundredNumbers(str.substring(str.length() - 3)) + " min " + hundredNumbers(str.substring(str.length() - 3));
        }
        return newstr;
    }
    public static String millionNumber(String str){
        String newstr="";
        if(str.substring(0,str.length()-6).length()==1) {
            newstr +=digitToString(str.charAt(0)) + " milyon " + thousandNumber(str.substring(str.length() - 6));
        }else if(str.substring(0,str.length()-6).length()==2) {
            newstr +=decimalNumber(str.substring(0,str.length()-6)) + " milyon  " + thousandNumber(str.substring(str.length() - 6));
        }else if(str.substring(0,str.length()-6).length()==3) {
            newstr +=thousandNumber(str.substring(str.length() - 6)) + " milyon " + thousandNumber(str.substring(str.length() - 6));
        }
        return newstr;
    }
    public static String billionNumber(String str){
        String newstr="";
        if(str.substring(0,str.length()-9).length()==1) {
            newstr +=digitToString(str.charAt(0)) + " milyard " + millionNumber(str.substring(str.length() - 9));
        }else if(str.substring(0,str.length()-9).length()==2) {
            newstr +=decimalNumber(str.substring(0,str.length()-9)) + " milyard  " + millionNumber(str.substring(str.length() - 9));
        }else if(str.substring(0,str.length()-9).length()==3) {
            newstr +=thousandNumber(str.substring(str.length() - 9)) + " milyard " + millionNumber(str.substring(str.length() - 9));
        }
        return newstr;
    }



}
