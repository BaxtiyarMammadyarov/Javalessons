package az.sibdtm.jdbc;




import java.util.Scanner;

public class Regist_User {


    public static void main(String[] args) {
        UserService userService=new UserService();
        boolean loop = true;
        Scanner scn = new Scanner(System.in);
        while (loop) {
            System.out.println("daxil olmaq ucun 1\nqeydiyyatdan kecmek ucun 2\ncixish ucun 0 secin\n");
            System.out.print("seciminiz :");
            int num = scn.nextInt();
            switch (num) {
                case 1:
                  userService.login();
                    break;
                case 2:
                    userService.signIn();
                    break;
                case 0:
                    System.out.println(" sistemden cixdiniz");
                    loop = false;
                    break;
            }

        }
    }



}
