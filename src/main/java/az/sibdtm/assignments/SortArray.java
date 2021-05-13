package az.sibdtm.assignments;

import java.lang.reflect.Array;

public class SortArray {
    public static void main(String[] args) {
        int[]arr1={1,4,2,5,12,3};
        int[]arr2={3,7,9,6,12,1};

         printArray(sortArray(arr1));
        System.out.println();
        printArray(sortArray(arr2));
        System.out.println();
        printArray(concatArray(arr1,arr2));
        System.out.println();
        printArray(sortArray(concatArray(arr1,arr2)));

    }
    public static void printArray(int[] arr){
        for (int i:arr)
            System.out.print(i+" ");
    }

    public static int[] sortArray(int[]array){
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    array[i]=array[i]+array[j];
                    array[j]=array[i]-array[j];
                    array[i]=array[i]-array[j];
                }
            }
        }
        return array;
    }

    public static int[] concatArray(int[] arr1,int[]arr2){
        int[] newarray=new int[arr1.length+arr2.length];
        for (int i=0;i<newarray.length;i++){
            if(i<arr1.length){
                newarray[i]=arr1[i];
            }else{
                newarray[i]=arr2[i-arr1.length];
            }
        }
        return newarray;
    }

}
