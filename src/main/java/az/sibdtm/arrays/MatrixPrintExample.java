package az.sibdtm.arrays;

public class MatrixPrintExample {
    public static void main(String[] args) {
        int[][] array={{12,15},{14,41},{9,4},{5,8}};

        printMatrix(array);

    }
    public static void printMatrix(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j]);
            }
            System.out.println();
        }

    }
}
