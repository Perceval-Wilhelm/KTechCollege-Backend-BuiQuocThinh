package vn.edu.likelion.day12;

public class Father <T, U> {
    private T age;
    private U name;

    public Father() {}

    public Father(T age, U name1) {
        this.age = age;
        name = name1;
    }

    public void setAge(T age) {
        this.age = age;
    }
    public T getAge() {
        return age;
    }

    public void setName(U name) {
        this.name = name;
    }
    public U getName() {
        return name;
    }
}
