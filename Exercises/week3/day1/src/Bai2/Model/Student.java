package Bai2;

import java.time.LocalDate;

public class Student {
    // Init variables
    private int studentId;
    private String name;
    private LocalDate dateOfBirth;
    private int ID;

    // Constructor
    public Student(int studentId, String name, int age, LocalDate dateOfBirth, int ID) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.ID = ID;
    }

    public Student() {}

    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
