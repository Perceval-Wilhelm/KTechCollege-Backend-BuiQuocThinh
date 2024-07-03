package vn.edu.likelion.day12;

public class SonMain {
    public static void main(String[] args) {
        Son son = new Son();
        String str = son.doSomeThing("xem tivi");
        int i = son.doSomeThing(123);
        Double d = son.doSomeThing(1.0);
        System.out.println(str + " " + i + " " + d);
    }
}
