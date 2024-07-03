package vn.edu.likelion.day13;

public class Application {
    public static void main(String[] args) {
        // Normal use case
//        Hello hello = new Hello();
//        hello.sayHello();

        // Lambda use case
        BaseInterface hello2 = () -> System.out.println("Hello World");
        hello2.sayHello();
    }
}
