package vn.edu.likelion.day16;

public class Person2 extends Thread {
    private String name;

    public Person2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name);
        }
    }

}
