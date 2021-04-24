package az.sibdtm.arrays;

// -------------------6 ve 10 cu sual-------------

public class AddElementArray {
    public static void main(String[] args) {
        int[] array = {12, 14, 9, 4,7, 5, 8};
        int[] addlast = addElementArray(43, array);
        int[] addfirst = addFirstElementArray(44, array);
        int[] addcenter = addElementCenterArray(55, array);
        System.out.println("----add last-----");
        printArray(addlast);
        System.out.println("\n----add first-----");
        printArray(addfirst);
        System.out.println("\n----add first-----");
        printArray(addcenter);
    }

    public static void printArray(int[] arry) {
        for (int i : arry) {
            System.out.print(" " + i);
        }
    }

    public static int[] addElementArray(int element, int[] array) {
        int[] result = new int[array.length + 1];
        int k = 0;
        for (int i : array) {
            result[k] = i;
            k++;
        }
        result[array.length] = element;
        return result;
    }

    public static int[] addFirstElementArray(int element, int[] array) {
        int[] result = new int[array.length + 1];
        result[0] = element;
        int k = 1;
        for (int i : array) {
            result[k] = i;
            k++;
        }
        return result;
    }

    public static int[] addElementCenterArray(int element, int[] array) {
        int[] result = new int[array.length + 1];
        int centerindex = centerArray(array);
        int k = 0;
        for (int i : array) {
            if (centerindex == k) {
                result[k] = element;
                k++;
            }
            result[k] = i;
            k++;
        }
        return result;
    }

    public static int centerArray(int[] array) {
        if (array.length % 2 == 0) return (array.length / 2) ;
        else return array.length / 2;
    }
}
