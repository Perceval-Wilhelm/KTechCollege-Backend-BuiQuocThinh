package Bai2.Model;

import java.time.LocalDate;

public class Student extends People {
    // Init variables
    private String studentId;
    private boolean status;

    // Constructor
    public Student(String name, LocalDate dateOfBirth, int ID) {
        super(name, ID, dateOfBirth);
        this.status = false;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void show() {
        System.out.println("Student ID: " + studentId + ", Student Name: " + getName() + ", Student day of birth: " + getDateofBirth() + ", ID: " + getID() + ", Student status: " + status);
    }
}
