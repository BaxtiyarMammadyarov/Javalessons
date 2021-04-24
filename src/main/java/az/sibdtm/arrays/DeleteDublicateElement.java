package az.sibdtm.arrays;


public class DeleteDublicateElement {
    public static void main(String[] args) {
        Integer[] array = {12, 14, 9, 4, 14, 5, 5,12,18};
        int[] newarray=deleteDublicateElement(array);
        for (int i:newarray ) {
            System.out.print(i+" ");

        }

    }

    public static int[] deleteDublicateElement(Integer[] array) {

        int[] result = new int[array.length - countAllRepeatElement(array)];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    array[j] = null;

                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                result[k] = array[i];
                k++;
            }
        }
        return result;
    }


    public static int countAllRepeatElement(Integer[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) count++;
            }
        }
        return count;
    }

}
