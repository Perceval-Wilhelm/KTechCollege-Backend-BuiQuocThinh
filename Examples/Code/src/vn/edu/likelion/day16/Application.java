package vn.edu.likelion.day16;

public class Application {
    public static void main(String[] args) {

        // Khởi tạo thằng cha Runnable bằng đối tượng con
        Runnable run = new Person("Tấn");
        Thread thread1 = new Thread(run);

        // Khởi tạo 1 đối tượng đã extends Thread
        Thread thread2 = new Person2("Thịnh");

        thread1.setPriority(3);
        // khởi tại luồng thứ 1, sau đó gọi phương thức run()
        //thread1.start();
        // khởi tạo luồng thứ 2, sau đó gọi phương thức run()
        //thread2.start();

        // Khởi tạo cái tài khoản ngân hàng
        Account account = new Account( 15);
        Runnable run1 = new Banking(account);
        Runnable run2 = new Banking(account);

        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.start();
        t2.start();
    }
}
