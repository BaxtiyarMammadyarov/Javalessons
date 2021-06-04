package az.sibdtm.jdbc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Regist_User {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scn = new Scanner(System.in);
        String username;
        while (loop) {
            System.out.print("daxil olmaq ucun 1 ,qeydiyyatdan kecmek ucun 2, cixish ucun 0 secin");
            int num = scn.nextInt();
            switch (num) {
                case 1:
                    login();
                    break;
                case 2:
                    signIn();
                    break;
                case 0:
                    System.out.println(" sistemden cixdiniz");
                    loop = false;
                    break;
            }

        }
    }

    public static void login() {
        Scanner scn = new Scanner(System.in);
        System.out.print(" input username :");
        String username;
        username = scn.next();
        System.out.print("input password :");
        String password = scn.next();

    }

    public static String signIn() {
        Service service = new Service();
        Scanner scn = new Scanner(System.in);
        UserEntity entity = new UserEntity();
        Set<String> phoneSet = new HashSet<>();
        System.out.print(" input name :");
        entity.setName(scn.next());
        System.out.print(" input surname :");
        entity.setSurname(scn.next());
        System.out.print(" input email :");
        while (true) {
            System.out.print(" input email :");
            String email = scn.next();
            if (service.exsistByEmail(email)) {
                System.out.println("email is available in the database");
            } else {
                entity.setEmail(email);
                break;
            }
        }

        System.out.print(" input extraEmail :");
        entity.setExtraEmail(scn.next());

        while (true) {
            System.out.print(" input username :");
            String username = scn.next();
            if (service.exsistByUsername(username)) {
                System.out.println("username is available in the database");
            } else {
                entity.setUsername(username);
                break;
            }
        }
        while (true) {
            System.out.print("input password :");
            String password = scn.next();
            System.out.print("input repeat password:");
            String repeatPassword = scn.next();
            if (password.equals(repeatPassword)) {
                entity.setPassword(password);
                break;
            } else {
                System.out.println("the entered passwords do not match");
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.print("input phoneNumber" + i + " : ");
            String phoneNumber = scn.next();
            phoneSet.add(phoneNumber);
        }
        entity.setPhoneList(phoneSet);
        return "successful registration";
    }

}
