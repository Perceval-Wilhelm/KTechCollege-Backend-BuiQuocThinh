package Bai1.Method3;

public class Main {
    public static void main(String[] args) {
        Thread thread5 = new Odd3(20);
        Thread thread6 = new Even3(20);
        thread5.start();
        thread6.start();
    }
}
