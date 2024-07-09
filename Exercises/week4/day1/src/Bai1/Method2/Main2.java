package Bai1;

public class Main2 {
    public static void main(String[] args) {
        Runnable run = new Odd2(20);
        Runnable run2 = new Even2(20);
        Thread thread3 = new Thread(run);
        Thread thread4 = new Thread(run2);
        thread3.start();
        thread4.start();
    }
}
