package Seminar_6;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class NotebookDatabase {
    private static final String DATABASE_FILE = "Seminar_6/notebook_database.ser";

    private Set<Notebook> notebooks;

    public NotebookDatabase() {
        notebooks = new HashSet<>();
    }

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public void saveDatabase() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATABASE_FILE))) {
            outputStream.writeObject(notebooks);
            System.out.println("База данных ноутбуков сохранена в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDatabase() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATABASE_FILE))) {
            notebooks = (Set<Notebook>) inputStream.readObject();
            System.out.println("База данных ноутбуков загружена из файла.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Set<Notebook> getNotebooks() {
        return notebooks;
    }
}
