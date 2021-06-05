package az.sibdtm.jdbc;

import org.json.simple.JSONObject;

import java.sql.Date;
import java.util.Scanner;

public class UserService {
    private static UserRepo repo = new UserRepo();

    public void login() {
        Scanner scn = new Scanner(System.in);
        System.out.print(" input username :");
        String username = scn.next();
        System.out.print("input password :");
        String password = scn.next();
        if (repo.exsistByUsername(username) && repo.exsistByPassword(username, password)) {
            System.out.println("daxil oldunuz");
            System.out.println(repo.get(username));

        } else {
            System.out.println("username or password is incorrect");
            System.out.println("Do you want to change the password? y/n");
            String answer = scn.next();
            if (answer.equals("y")) {
                System.out.println(repo.updateUserPassword());
            } else {

            }
        }
    }


    public String signIn() {

        Scanner scn = new Scanner(System.in);
        String answer = "successful registration";
        UserDto entity = new UserDto();
        JSONObject jsonObject = new JSONObject();
        System.out.print(" input name :");
        entity.setName(scn.next());
        System.out.print(" input surname :");
        entity.setSurname(scn.next());

        System.out.print(" input email :");
        String email = scn.next();
        entity.setEmail(email);
        System.out.print(" input extraEmail :");
        entity.setExtraEmail(scn.next());

        System.out.print(" input username :");
        String username = scn.next();
        entity.setUsername(username);
        System.out.print("input password :");
        String password = scn.next();
        entity.setPassword(password);

        for (int i = 0; i < 3; i++) {
            System.out.print("input phoneNumber " + (i + 1) + " : ");
            String phoneNumber = scn.next();
            jsonObject.put("phone " + (i + 1), phoneNumber);
        }
        entity.setPhoneList(jsonObject);
        Date date = new Date(System.currentTimeMillis());
        entity.setDate(date);
        if (repo.exsistByEmail(entity.getEmail())) {
            answer = "email registered,\n" +
                    "Enter another email";
        } else {
            if (repo.exsistByUsername(username)) {
                answer = "username is available";
            } else {
                repo.createUser(entity);
                answer = "successful registration";
            }
        }
        return answer;
    }
}
