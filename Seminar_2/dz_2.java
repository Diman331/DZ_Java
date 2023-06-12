package Seminar_2;

import java.io.FileWriter;
import java.io.IOException;

public class dz_2 {
    public static void main(String[] args) {
        int[] array = { 5, 3, 8, 2, 1 };

        try {
            FileWriter logFile = new FileWriter("Seminar_2/bubble_sort.log");

            logFile.write("Исходный массив: ");
            printArray(array, logFile);

            bubbleSort(array, logFile);

            logFile.write("Отсортированный массив: ");
            printArray(array, logFile);

            logFile.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в лог-файл: " + e.getMessage());
        }
    }

    public static void bubbleSort(int[] array, FileWriter logFile) throws IOException {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            logFile.write("Итерация " + (i + 1) + ": ");
            printArray(array, logFile);

            // Если внутренний цикл не выполнил ни одной замены, массив уже отсортирован
            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] array, FileWriter logFile) throws IOException {
        for (int i = 0; i < array.length; i++) {
            logFile.write(array[i] + " ");
        }
        logFile.write("\n");
    }
}
