package hometask1.t04;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

    /**Method which creates double[] array reading strings from console.
     * Strings are separated by " " element.
     *
     *
     * @return
     */
    private static double[] getArrayfromConsole(){
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        double[] numbers = new double[tokens.length];
        for(int i = 0 ; i < tokens.length; i++)
            numbers[i] = Double.parseDouble(tokens[i]);
        return numbers;
    }

    public static void main(String[] args) {
        double[] array = getArrayfromConsole();
        double max = Integer.MIN_VALUE;
        int n = array.length;
        System.out.println(Arrays.toString(array));
        for (int i = 0; i <= n / 2; i++) {
            if (array[i] + array[n - 1 - i] > max)
                max = array[i] + array[n - 1 - i];
            System.out.println(max);
        }
        System.out.println("Max = " + max);
    }
}
