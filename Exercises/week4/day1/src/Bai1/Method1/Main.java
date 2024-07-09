package Bai1.Method1;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Odd(20);
        Thread thread2 = new Even(20);
        thread.start();
        thread2.start();
    }
}
