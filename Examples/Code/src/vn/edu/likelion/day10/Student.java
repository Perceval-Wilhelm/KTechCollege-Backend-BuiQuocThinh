package vn.edu.likelion.day10;

public class Student {

    // Đây là thuộc tính, là đặc điểm của đối tượng khái quát Student
    String name;
    int age;
    final int id = 123456789;

    // khai báo 1 constructor mặc định
    public Student() {

    }

    // Khai báo 1 constructor có tham số name
    public Student(String name) {
        this.name = name;
    }

    // khai báo 1 constructor có tham số age
    public Student(int age) {
        this.age = age;
    }

    // Khai báo 1 constructor có cả 2 tham số
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Khai bao 1 method final
    public final void abc() {}

}
