package az.sibdtm.arrays;

public class MinArray {
    public static void main(String[] args) {
        int[] array = {12, 14, 9, 4, 5, 8};

        System.out.println(minArray(array));

    }

    public static int minArray(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if ((min > array[i])) {
                min = array[i];
            }
        }
        return min;
    }
}
