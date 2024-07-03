package vn.edu.likelion.day13.lambda;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Normal use case
//        Hello hello = new Hello();
//        hello.sayHello();

        // Lambda use case
        // Print Hello World
//        BaseInterface hello2 = () -> System.out.println("Hello World");

//        BaseInterface hello2 = (name) -> System.out.println("Hello World " + name);
//        hello2.sayHello("Thinh");

        // Multiply
        BaseInterface hello2 = (x, y) -> {
            // if use return then { } is needed
            return x * y;
        };

        int x = 10;
        int y = 20;

        System.out.println(hello2.calculator(x, y));

        // For each
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("PHP");
        list.add("C++");
        list.add("Python");

        list.forEach((element) -> System.out.println(element));
    }
}
