package az.sibdtm.arrays;


public class DeleteArrayByElement {
    public static void main(String[] args) {
        int[] array = {12, 14, 9, 4, 5, 8,14};
        int[] newarray = deleteArrayByElement(144, array);
        for (int i : newarray) {
            System.out.print(" " + i);
        }
    }

    public static int[] deleteArrayByElement(int element, int[] array) {
        int[] result = new int[array.length - countRepeatArrayByElement(element,array)];
        int k = 0;
            for (int i : array) {
                if (element == i) {
                    continue;
                } else {
                    result[k] = i;
                    k++;
                }
            }
        return result;
    }

    public static int countRepeatArrayByElement(int element, int[]array){
        int count=0;
        for (int i:array){
            if(element==i) count++;
        }
        return count;
    }


}

