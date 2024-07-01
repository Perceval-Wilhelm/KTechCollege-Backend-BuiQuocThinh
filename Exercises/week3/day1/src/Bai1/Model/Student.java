package Bai1.Model;

public class Student {
    // Init variables
    private int studentId;
    private String name;
    private int age;
    private String gender;
    private String major;

    // Constructor
    public Student(int studentId, String name, int age, String gender, String major) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.major = major;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student getStudent() {
        return this;
    }

    // Display student detail
    public void showStudentDetail() {
        System.out.println("Student ID: " + studentId + ", Student Name: " + name + ", Student Age: " + age + ", Student Gender: " + gender + ", Student Major: " + major);
    }
}
