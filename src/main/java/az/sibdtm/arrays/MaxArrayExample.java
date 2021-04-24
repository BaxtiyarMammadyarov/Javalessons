package az.sibdtm.arrays;

public class MaxArrayExample {
    public static void main(String[] args) {
        int[] array = {12, 14, 9, 4, 5, 8};

        System.out.println(maxArray(array));

    }

    public static int maxArray(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if ((max < array[i])) {
                max = array[i];
            }
        }
        return max;
    }
}
