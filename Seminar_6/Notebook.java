package Seminar_6;

import java.io.Serializable;

public class Notebook implements Serializable {
    private static final long serialVersionUID = 1L;

    private int ram;
    private int storage;
    private String operatingSystem;
    private String color;

    public Notebook(int ram, int storage, String operatingSystem, String color) {
        this.ram = ram;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }
}
