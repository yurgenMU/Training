package hometask1.t03;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a :");
        double a = Double.parseDouble(sc.nextLine());
        System.out.println("Choose b :");
        double b = Double.parseDouble(sc.nextLine());
        System.out.println("Choose h :");
        double h = Double.parseDouble(sc.nextLine());


        functionT(a,b, h);
    }

    private static void functionT(double a, double b, double h){
        double f = 0;
        while (a <= b){
            a += h;
            f = Math.tan(2*a) - 3;
            System.out.println(a +": " + f);
        }

    }
}
