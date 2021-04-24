package az.sibdtm.arrays;

import static az.sibdtm.arrays.DeleteArrayByElement.countRepeatArrayByElement;
import static az.sibdtm.arrays.MaxArrayExample.maxArray;

public class MaxRepeatElement {
    public static void main(String[] args) {
        int[] array = {12, 14, 9, 4, 5, 8, 14, 9, 9};
        System.out.println(maxRepeatElement(array));
    }

    public static int maxRepeatElement(int[] array) {
        int[] countarr = new int[array.length];
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            countarr[i] = countRepeatArrayByElement(array[i], array);

        }
        int max = maxArray(countarr);
        for (int i = 0; i < countarr.length; i++) {
            if (max == countarr[i]) {
                result = array[i];
                break;
            }

        }
        return result;
    }

}

