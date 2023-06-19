package Seminar_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class dz {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
    try (Scanner scanner = new Scanner(System.in, "cp866")){

        while (true) {
            System.out.print("Введите имя и номер телефона (или 'exit' для выхода): ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            String name = parts[0];
            String phoneNumber = parts[1];

            List<String> numbers = phoneBook.getOrDefault(name, new ArrayList<>());
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        System.out.println("Телефонная книга:");

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();

            System.out.println(name + " " + numbers);
        }
    }
}
