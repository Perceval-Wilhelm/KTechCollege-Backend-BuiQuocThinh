package Bai2.Model;

import java.time.LocalDate;

abstract public class People {
    // Init variables
    private String name;
    private LocalDate dateofBirth;
    private int ID;

    // Constructor
    public People(String name, int ID, LocalDate dateofBirth) {
        this.name = name;
        this.ID = ID;
        this.dateofBirth = dateofBirth;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
