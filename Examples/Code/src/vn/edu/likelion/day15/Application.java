package vn.edu.likelion.day15;

import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        // tạo ra 1 đối tượng optional rỗng
        Optional<String> opt = Optional.empty();

        // tạo ra 1 đối tượng non-null (có thể có giá trị hoặc empty)
        String str = "Hello KTC";
        Optional<String> opt2 = Optional.of(str);
        System.out.println(opt2.isPresent());
        if (opt2.isPresent()) {
            System.out.println(str);
        } else {
            System.out.println("ko co gia trị");
        }

        if (str == null) {
            //todo
        }

        // Giả dụ đây là thư viện StringUtils của Apache common
        if (StringUtils.isNullOrEmpty(str)) {
            //todo
        }

        // tạo ra 1 đối tượng cho phép null hoặc non-null
        String str2 = null;
        Optional<String> opt3 = Optional.ofNullable(str2);

        // Kiểm tra đối tượng Person có null hay ko
        Person per = new Person("Tấn");
        Optional<Person> optional = Optional.ofNullable(per);

        // kiểm tra đối tượng Persion có giá trị hay ko, ko thì hiển thị
        optional.ifPresent(System.out::println);

        Optional<String> opt4 = optional.map(Person::getName);
        System.out.print("Tên của class Person là: ");
        // Kiểm tra đối tượng String (ở đây là name của Person) có giá trị hay ko
        opt4.ifPresent(System.out::println);

        // tạo 1 đối tượng Optional emtpy
        Optional<Person> perEmpty = Optional.empty();
        System.out.println("Dân hỏi - IDE trả lời: " + perEmpty);
        Optional<String> test = perEmpty.map(Person::getName);
        //System.out.print("Test trường hợp Otional<Person> là empty: ");
        test.ifPresent(System.out::println);

        // tạo 1 đối tượng Optional empty khác
        Optional<String> vinhHoi = Optional.empty();
        System.out.println("\nVinh hỏi - IDE trả lời: " + vinhHoi);


    }
}
