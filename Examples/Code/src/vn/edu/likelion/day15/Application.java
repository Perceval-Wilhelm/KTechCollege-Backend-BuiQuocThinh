package vn.edu.likelion.day15;

import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        // Create 1 empty optional object
        Optional<String> opt1 = Optional.empty();

        // Create a non-null object (can contain value or empty)
        String str = "";
        Optional<String> opt2 = Optional.of(str);
        System.out.println(opt2.isPresent());
        if (opt2.isPresent()) {
            System.out.println(str);
        }
        else {
            System.out.println("No value");
        }

        opt2.ifPresent(System.out::println);

        if (str==null) {

        }

        if (StringUtils.isNullOrEmpty(str)) {

        }

        // Create an object allow null or non-null
        String str2 = null;
        Optional<String> opt3 = Optional.ofNullable(str2);
//        System.out.println(opt3.isPresent());

        // Check whether person object is null or not
        Person per = new Person();
        Optional<Person> opt4 = Optional.ofNullable(per);
        opt4.ifPresent(System.out::println);
    }
}
