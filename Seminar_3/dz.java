package Seminar_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class dz {
    public static void main(String[] args) {
        List<Integer> numbers = generateRandomNumbers(10, 1, 100);

        System.out.println("Список: " + numbers);

        List<Integer> oddNumbers = removeEvenNumbers(numbers); // Удаление чётных чисел
        System.out.println("Список с удалёнными чётными числами: " + oddNumbers);

        int min = findMinimum(oddNumbers); // Поиск минимального значения
        System.out.println("Минимальное значение: " + min);

        int max = findMaximum(oddNumbers); // Поиск максимального значения
        System.out.println("Максимальное значение: " + max);

        double average = findAverage(oddNumbers); // Поиск среднего значения
        System.out.println("Среднее значение: " + average);
    }

    public static List<Integer> generateRandomNumbers(int count, int min, int max) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            numbers.add(randomNumber);
        }

        return numbers;
    }

    public static List<Integer> removeEvenNumbers(List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 != 0) {
                oddNumbers.add(number);
            }
        }
        return oddNumbers;
    }

    public static int findMinimum(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    public static int findMaximum(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    public static double findAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.size();
    }
}
