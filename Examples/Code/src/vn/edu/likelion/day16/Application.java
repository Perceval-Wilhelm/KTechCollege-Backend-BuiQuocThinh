package vn.edu.likelion.day16;

public class Application {
    public static void main(String[] args) {

        // Khởi tạo thằng cha Runnable bằng đối tượng con
        Runnable run = new Person("Tan");
        Thread thread = new Thread(run);
        thread.start();

        // Khởi tạo 1 đối tượng đã extends thread
        Thread thread2 = new Person2("Thinh");

    }
}
