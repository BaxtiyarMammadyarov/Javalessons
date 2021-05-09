package az.sibdtm.assignments;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqeList {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("str");
        list.add("str1");
        list.add("str");
        list.add("str2");
        list.add("str3");
        list.add("str1");
        list.add("str1");
        System.out.println(uniqeList(list));

    }

    public static List<String> uniqeList(List<String> list){
        Set<String> stringSet=new HashSet<>();
        for(String str:list){
            stringSet.add(str);
        }
        list.clear();
        for (String str:stringSet){
            list.add(str);
        }
        return list;
    }

}
