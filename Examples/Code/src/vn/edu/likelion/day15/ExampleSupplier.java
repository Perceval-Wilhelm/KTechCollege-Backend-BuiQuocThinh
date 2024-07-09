package vn.edu.likelion.day15;

import java.util.function.Supplier;

class Somebody {
    private String name;
    private int age;

    public Somebody(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
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
}

public class ExampleSupplier {
    public static void main(String[] args) {
        // Tạo một Supplier để in ra thông tin của Somebody
        // Sử dụng Lambda expression
        Supplier<Somebody> somebodySupplier = () -> new Somebody("Đức Tấn", 25);

        // Sử dụng Supplier để lấy một đối tượng Person thông qua phương thức get()
        Somebody somebody = somebodySupplier.get();

        // In thông tin đối tượng Somebody ra màn hình console
        System.out.println("Name: " + somebody.getName());
        System.out.println("Age: " + somebody.getAge());

    }
}
