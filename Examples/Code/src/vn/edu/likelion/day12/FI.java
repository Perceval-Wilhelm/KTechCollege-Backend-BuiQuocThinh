package vn.edu.likelion.day12;

@FunctionalInterface
public interface FI {
    // functional interface chi co 1 abstract method duy nhat
    void timX(int i);

    // functional interface co the su dung cac
    // method cua lop java.lang.Object
    String toString();
    boolean equals(Object obj);
}
