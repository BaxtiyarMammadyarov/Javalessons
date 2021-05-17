package az.sibdtm.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {
        File file = new File("D:\\IdeaProjects\\Javalessons\\src\\main\\java\\az\\sibdtm\\file\\dictioary.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scn = new Scanner(System.in);
        boolean loop = true;
        List<String> list;
        while (loop) {
            System.out.print("Input word : ");
            String str = scn.next();
            if (file.length() != 0) {
                list = readFile(file).stream().filter(s -> {
                    if (s.equals(str)) return true;
                    else if (s.length() > str.length() && s.startsWith(str)) return true;
                    else return false;
                }).collect(Collectors.toList());
                if (list.size() != 0) {
                    list.stream().forEach(System.out::println);
                } else {
                    System.out.println("the word does not exist in the dictionary");
                    loop = questionAnswer(file, scn, str);
                }
            } else {
                System.out.println("the dictionary is empty");
                loop = questionAnswer(file, scn, str);
            }

        }


    }

    public static boolean questionAnswer(File file, Scanner scn, String str) {
        boolean result = true;
        while (true) {
            System.out.print("Do you want to include it in the dictionary? y / n : ");
            String answer = scn.next();

            if (answer.equals("y")) {
                writeFile(file, str);
                break;
            } else if (answer.equals("n")) {
                result = false;
                break;
            } else {
                System.out.println("the choice is not correct!!!");
            }
        }
        return result;
    }


    public static void writeFile(File file, String str) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.newLine();
            writer.write(str);
            System.out.println("save word");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(File file) {

        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            list = reader.lines().collect(Collectors.toList());
            System.out.println("read file");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}