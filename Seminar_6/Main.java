package Seminar_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Доброго времени суток!");
        NotebookDatabase database = new NotebookDatabase();
        database.loadDatabase();

        Scanner scanner = new Scanner(System.in, "cp866");

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить ноутбук");
            System.out.println("2 - Фильтрация ноутбуков");
            System.out.println("3 - Вывести все ноутбуки");
            System.out.println("4 - Сохранить базу данных");
            System.out.println("5 - Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Считываем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    Notebook notebook = createNotebookFromUserInput(scanner);
                    database.addNotebook(notebook);
                    break;
                case 2:
                    filterNotebooks(database.getNotebooks(), scanner);
                    break;
                case 3:
                    printNotebooks(database.getNotebooks());
                    break;
                case 4:
                    database.saveDatabase();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод.");
                    break;
            }
        }
    }

    public static Notebook createNotebookFromUserInput(Scanner scanner) {
        System.out.println("Введите характеристики ноутбука:");
        System.out.print("ОЗУ: ");
        int ram = scanner.nextInt();

        System.out.print("Объем ЖД: ");
        int storage = scanner.nextInt();
        scanner.nextLine();  // Считываем символ новой строки после ввода числа

        System.out.print("Операционная система: ");
        String operatingSystem = scanner.nextLine();

        System.out.print("Цвет: ");
        String color = scanner.nextLine();

        return new Notebook(ram, storage, operatingSystem, color);
    }

    public static void filterNotebooks(Set<Notebook> notebooks, Scanner scanner) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        int criteria = scanner.nextInt();
        scanner.nextLine();  // Считываем символ новой строки после ввода числа

        Map<String, String> filter = new HashMap<>();

        switch (criteria) {
            case 1:
                System.out.println("Введите минимальное значение ОЗУ:");
                int minRam = scanner.nextInt();
                filter.put("ram", String.valueOf(minRam));
                break;
            case 2:
                System.out.println("Введите минимальный объем ЖД:");
                int minStorage = scanner.nextInt();
                filter.put("storage", String.valueOf(minStorage));
                break;
            case 3:
                System.out.println("Введите название операционной системы:");
                String os = scanner.nextLine();
                filter.put("operatingSystem", os);
                break;
            case 4:
                System.out.println("Введите цвет:");
                String color = scanner.nextLine();
                filter.put("color", color);
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }

        Set<Notebook> filteredNotebooks = filterNotebooks(notebooks, filter);
        printNotebooks(filteredNotebooks);
    }

    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, String> filter) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : notebooks) {
            boolean passedFilter = true;

            for (Map.Entry<String, String> entry : filter.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (key.equals("ram")) {
                    if (notebook.getRam() < Integer.parseInt(value)) {
                        passedFilter = false;
                        break;
                    }
                } else if (key.equals("storage")) {
                    if (notebook.getStorage() < Integer.parseInt(value)) {
                        passedFilter = false;
                        break;
                    }
                } else if (key.equals("operatingSystem")) {
                    if (!notebook.getOperatingSystem().equals(value)) {
                        passedFilter = false;
                        break;
                    }
                } else if (key.equals("color")) {
                    if (!notebook.getColor().equals(value)) {
                        passedFilter = false;
                        break;
                    }
                }
            }

            if (passedFilter) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

    public static void printNotebooks(Set<Notebook> notebooks) {
        if (notebooks.isEmpty()) {
            System.out.println("Нет ноутбуков, удовлетворяющих фильтру.");
        } else {
            System.out.println("Найденные ноутбуки:");
            for (Notebook notebook : notebooks) {
                System.out.println("ОЗУ: " + notebook.getRam() + ", Объем ЖД: " + notebook.getStorage()
                        + ", Операционная система: " + notebook.getOperatingSystem() + ", Цвет: " + notebook.getColor());
            }
        }
    }
}
