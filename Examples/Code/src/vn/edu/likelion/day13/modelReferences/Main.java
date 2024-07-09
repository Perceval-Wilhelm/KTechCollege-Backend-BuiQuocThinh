package vn.edu.likelion.day13.modelReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*
         * Ví dụ sử dụng lambda expression
         */

        // Khai báo 1 list person
        List<Person> people = new ArrayList<>();
        // Gán các instance Person vào danh sách person1
        people.add(new Person("Alice"));
        people.add(new Person("Bob"));
        people.add(new Person("Charlie"));

        // Sử dụng lambda expressions để lấy danh sách các tên
        List<String> names1 = people.stream()
                .map(person -> person.getName())
                .collect(Collectors.toList());

        System.out.println("Lambda: " +names1); // Output: [Alice, Bob, Charlie]

        /*
         * Ví dụ sử dụng method references
         */

        // Sử dụng method reference để lấy danh sách các tên
        // Syntax: object::instanceMethod
        List<String> names2 = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println("Method references: " + names2); // Output: [Alice, Bob, Charlie]

    }
}
