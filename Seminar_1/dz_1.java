package Seminar_1;
import java.util.Scanner;
public class dz_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число n: ");
        int n = sc.nextInt();

        int triangularNumber = calculateTriangularNumber(n);
        System.out.println("n-ое треугольное число: " + triangularNumber);

        int factorial = calculateFactorial(n);
        System.out.println("n!: " + factorial);

        sc.close();
    }

    public static int calculateTriangularNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int calculateFactorial(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}