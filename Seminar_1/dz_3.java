package Seminar_1;

import java.util.Scanner;

public class dz_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите первое число: ");
            double firstNumber = scanner.nextDouble();

            System.out.print("Введите знак (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            double secondNumber = scanner.nextDouble();

            double result = 0.0;

            switch (operator) {
                case '+':
                    result = firstNumber + secondNumber;
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    break;
                default:
                    System.out.println("Неверный оператор");
                    return;
            }

            System.out.println("Результат: " + result);
        } finally {
            scanner.close();
        }
    }
}
