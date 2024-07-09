package vn.edu.likelion.day15;

import java.util.Optional;
import java.util.function.Function;

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
        Person per = new Person("Thinh");
        Optional<Person> optional = Optional.ofNullable(per);

        // Check if Person object is null or not, present then print
        optional.ifPresent(System.out::println);

        Optional<String> opt4 = optional.map(Person::getName);
        System.out.println(opt4.get());

        // Check String obejct (here is the name of Person) has value or not
        opt4.ifPresent(System.out::println);

        // Create an empty Optional object
        Optional<Person> perEmpty = Optional.empty();
        System.out.println("Dân hỏi - IDE trả lời: " + perEmpty);
        Optional<String> test = perEmpty.map(Person::getName);
        System.out.println("Test truong hop Optional<Person> la empty: ");
        test.ifPresent(System.out::println);

        // Create another empty Optional
        String vinh = "Vinh";
        Optional<String> vinhHoi = Optional.empty();
        System.out.println("\nVinh hỏi - IDE trả lời: " + vinhHoi);

        // Not lambda
        Function<String, Integer> tan = new Function<String, Integer>() {
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        // lambda
        Function<String, Integer> tan2 = s -> Integer.parseInt(s);
        // method reference
        Function<String, Integer> tan3 = Integer::parseInt;
    }
}
