package hometask1.t05;

import java.util.Scanner;

public class Task5 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose matrix size");
        int size = sc.nextInt();
        createMatrix(size);
    }

    private static void createMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i == j) || (i == size - j - 1))
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
