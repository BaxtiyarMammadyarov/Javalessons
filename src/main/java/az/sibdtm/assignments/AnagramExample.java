package az.sibdtm.assignments;


import java.util.ArrayList;
import java.util.List;

public class AnagramExample {
    public static void main(String[] args) {
        String word1="turk";
        String word2="kurtt";

        System.out.println(anagramWord(word1,word2));



    }

    public static boolean anagramWord(String word1, String word2) {
        boolean ans = false;
        List<Character> list = new ArrayList<>();
        if (word1.length() == word2.length()) {
            for (char ch : word1.toUpperCase().toCharArray()) {
                list.add(ch);
            }
            for (char ch : word2.toUpperCase().toCharArray()) {
                if (list.contains(ch)) {
                    ans = true;
                } else {
                    ans = false;
                    break;
                }
            }
        }
        return ans;
    }
}
