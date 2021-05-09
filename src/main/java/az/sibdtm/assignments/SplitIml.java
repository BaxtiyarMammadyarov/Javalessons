package az.sibdtm.assignments;

import java.util.ArrayList;

import java.util.List;

public class SplitIml {
    public static void main(String[] args) {
        String str = "He isn't a stud''ent, is he? mm";
        for (String s : splitImpl(str)) {
            System.out.println(s);
        }


    }


    public static List<String> splitImpl(String str) {
        String subStr = new String();
        List<String> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                subStr += ch;
            } else {
                if (!subStr.equals("")) {
                    list.add(subStr);
                }
                subStr = "";
            }
        }
        if (!subStr.equals("")) {
            list.add(subStr);
        }
        return list;
    }
}
