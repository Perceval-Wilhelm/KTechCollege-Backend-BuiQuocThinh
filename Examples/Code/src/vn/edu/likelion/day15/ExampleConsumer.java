package vn.edu.likelion.day15;

import java.util.function.Consumer;

class Someone {
    private String name;
    private int age;

    public Someone(String name, int age) {
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

public class ExampleConsumer {
    public static void main(String[] args) {
        // Tạo một Consumer để in ra thông tin của Someone
        // Sử dụng Lambda expression - phần body nhiều dòng nên cần sử dụng { }
        Consumer<Someone> someoneInfoConsumer = someone -> {
            System.out.println("Name: " + someone.getName());
            System.out.println("Age: " + someone.getAge());
        };

        // Khởi tạo 1 instance Someone
        // Bước khởi tạo instance này ko phải là 1 tuần tự, có thể khởi tạo ngay khi vào hàm main cũng đc
        Someone someone = new Someone("Nguyễn Đức Tấn", 20);

        // Sử dụng phương thức accept() của Consumer để in ra thông tin của một đối tượng Someone
        someoneInfoConsumer.accept(someone);
    }
}
