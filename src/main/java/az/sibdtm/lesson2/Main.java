package az.sibdtm.lesson2;

public class Main {

    public static void main(String[] args) {
        outer_loop:
        for (int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if(j==5){
                  break outer_loop;
                }
            }
        }
    }
}
