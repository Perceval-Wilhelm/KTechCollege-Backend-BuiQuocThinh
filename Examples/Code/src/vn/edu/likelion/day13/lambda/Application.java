package vn.edu.likelion.day13.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

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
//        BaseInterface hello2 = (x, y) -> {
//            // if use return then { } is needed
//            return x * y;
//        };
//
//        int x = 10;
//        int y = 20;
//
//        System.out.println(hello2.calculator(x, y));

        // For each
//        List<String> list = new ArrayList<>();
//        list.add("Java");
//        list.add("PHP");
//        list.add("C++");
//        list.add("Python");
//
//        list.forEach((element) -> System.out.println(element));

        // Another example
//        BaseInterface hello3 = ((name, age) -> System.out.println("Hello " + name + " " + age));
//        hello3.info("Thinh", 22);

        // Function example
//        Function<String, Integer> fun = new Function<>() {
//            @Override
//            public Integer apply(String name) {
//                return Integer.parseInt(name);
//            }
//        };
//
//        fun.apply("123");

//        Function<String, Integer> fun = (name) -> Integer.parseInt(name);
//
//        fun.apply("123");

        // Method references examples
        int x = 5;
        int y = 10;
        // Call a static method
        // Syntax: Class::staticMethod
        int z = toDo(x, y, Service::tinhTong);
        System.out.println("Sum of x and y is: " + z);
    }

    public static int toDo(int x, int y, Calculator cal) {
        return cal.timXY(x, y);
    }
}
