package hometask1.t02;

public class Main {

    public static void main(String[] args) {
        findN(0.1);
    }

    private static int findN(double epsilon) {
        int count = 0;
        double a = 1;

        while (a >= epsilon) {
            count++;
            a = 1 / Math.pow(count + 1, 2);
            System.out.println("a[" + count +"] = " + a);
        }
        return count;
    }
}
