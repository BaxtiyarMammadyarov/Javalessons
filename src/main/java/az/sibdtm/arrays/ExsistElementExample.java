package az.sibdtm.arrays;

public class ExsistElementExample {
    public static void main(String[] args) {
        int[] array={12,14,9,4,5,8};

        System.out.println(exsistArrayByElement(15,array));
    }
    public static boolean exsistArrayByElement(int element, int[] array) {
        boolean result = false;
        for (int i : array) {
            if (i == element) {
                result = true;
                break;
            }
        }
        return result;
    }
}

