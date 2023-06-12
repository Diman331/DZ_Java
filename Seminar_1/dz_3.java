package Seminar_1;

import java.util.Scanner;

public class dz_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Некорректный ввод. Введите число: ");
            scanner.next();
        }
        double firstNumber = scanner.nextDouble();

        System.out.print("Введите знак (+, -, *, /): ");
        char operator;
        while (true) {
            String input = scanner.next();
            if (input.length() == 1) {
                operator = input.charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                }
            }
            System.out.println("Некорректный ввод. Введите один из знаков: +, -, *, /");
        }

        System.out.print("Введите второе число: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Некорректный ввод. Введите число: ");
            scanner.next();
        }
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

        scanner.close();
    }
}
