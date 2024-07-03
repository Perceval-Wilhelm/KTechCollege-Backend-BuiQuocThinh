package vn.edu.likelion.day11;

public interface StaticInterfaceAnimal1 {
    static void run() {
        System.out.println("StaticInterfaceAnimal11111");
    }

    default void run2() {
        System.out.println("run2");
    }
}
