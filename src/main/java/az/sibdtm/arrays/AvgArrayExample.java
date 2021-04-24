package az.sibdtm.arrays;

public class AvgArrayExample {
    public static void main(String[] args) {
        int[] array={12,14,9,4,5,8};

        System.out.println(avgArray(array));
    }
    public static double avgArray(int[] array) {
        double sum =0;
        for (int i : array) {
            sum+=i;
        }
        return sum / array.length;
    }
}
