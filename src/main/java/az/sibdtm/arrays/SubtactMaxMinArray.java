package az.sibdtm.arrays;

import static az.sibdtm.arrays.MaxArrayExample.maxArray;
import static az.sibdtm.arrays.MinArray.minArray;

public class SubtactMaxMinArray {
    public static void main(String[] args) {
        int[] array = {12, 14, 9, 4, 5, 8};
        System.out.println(maxArray(array)-minArray(array));
    }
}
