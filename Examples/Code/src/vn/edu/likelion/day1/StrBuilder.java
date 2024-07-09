package vn.edu.likelion.day1;

public class StrBuilder implements Runnable {

    static StringBuilder str = new StringBuilder();

    // run sẽ chạy song song với hàm main
    public void run()  {
        for (int i = 0; i < 10; i++) {
            str.append(Thread.currentThread().getName()).append(" ");
        }
    }

    public static void main(String[] args) {
        //Khởi tạo luồng 1
        Thread thread1 = new Thread(new StrBuilder(), "Thread 1");
        // Khởi tạo luồng 2
        Thread thread2 = new Thread(new StrBuilder(), "Thread 2");

        // gọi phương thức start để chạy đối tượng run
        thread1.start();
        thread2.start();

        try {
            // join là để main chờ cho đến khi thread kết thúc
            thread1.join();
            thread2.join();
        } catch (Exception e) {}

        System.out.println(str);
    }

}
