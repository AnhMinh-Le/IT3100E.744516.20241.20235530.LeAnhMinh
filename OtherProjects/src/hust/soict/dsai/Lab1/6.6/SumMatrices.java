import java.util.Scanner;

public class SumMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to input matrices? (y/n): ");
        char choice = scanner.next().charAt(0);

        int[][] matrix1, matrix2;
        int rows, cols;

        if (Character.toLowerCase(choice) == 'y') {
            System.out.println("Enter the number of rows: ");
            rows = scanner.nextInt();
            System.out.println("Enter the number of columns: ");
            cols = scanner.nextInt();

            matrix1 = new int[rows][cols];
            matrix2 = new int[rows][cols];

            System.out.println("Enter elements for the first matrix:");
            for (int i = 1; i < rows + 1; i++) {
                for (int j = 1; j < cols + 1; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrix1[i - 1][j - 1] = scanner.nextInt();
                }
            }

            System.out.println("Enter elements for the second matrix:");
            for (int i = 1; i < rows + 1; i++) {
                for (int j = 1; j < cols + 1; j++) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    matrix2[i - 1][j - 1] = scanner.nextInt();
                }
            }
        } else {
            rows = 3;
            cols = 3;
            matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            matrix2 = new int[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
            };
            System.out.println("Using fixed predefined matrices.");
        }

        int[][] result = addMatrices(matrix1, matrix2);

        System.out.println("The resulting matrix after the addition is: ");
        displayMatrix(result);

        scanner.close();
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
