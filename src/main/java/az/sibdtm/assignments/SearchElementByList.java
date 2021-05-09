package az.sibdtm.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SearchElementByList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add((int) Math.round(Math.random() * 100));
        }
        Collections.sort(list1);
        list1.stream().forEach(System.out::println);
        int element = 20;
        System.out.println(searchElementByList(element, list1));


    }

    public static int searchElementByList(int element, List<Integer> list) {
        Collections.sort(list);
        int index = 0;
        for (int i : list) {
            if (i == element) {
                break;
            } else if (element > i) {
                index++;
            } else {
                break;
            }
        }
        return index;
    }

}

