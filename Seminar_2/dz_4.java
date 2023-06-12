package Seminar_2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class dz_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("Seminar_2/calculation.log", true);

            System.out.print("Введите первое число: ");
            double firstNumber = readDouble(scanner);

            System.out.print("Введите знак (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Введите второе число: ");
            double secondNumber = readDouble(scanner);

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

            // Запись в файл лога
            String logEntry = firstNumber + " " + operator + " " + secondNumber + " = " + result;
            fileWriter.write(logEntry + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            scanner.close();
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next(); // Пропускаем некорректное значение
            }
        }
    }
}
