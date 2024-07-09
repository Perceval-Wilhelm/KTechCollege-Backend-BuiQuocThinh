package vn.edu.likelion.day13;

public class Application {
    public static void main(String[] args) {

        // đây là cách thông thường
        //Hello hello = new Hello();
        //hello.sayHello();

        // sử dụng lambda
//        BaseInterface hello2 = (name, age) -> System.out.println("I'm " + name + ", I " + age + " years aold");
//
//        hello2.printInfo("nam", 22);
//
//        Function<String, Integer> fun = new Function<>() {
//            @Override
//            public Integer apply(String name) {
//                return Integer.parseInt(name);
//            }
//        };
//
//        fun.apply("123");

        // Sử dụng method references
        int x = 5;
        int y = 10;
        // gọi đến 1 static method
        // syntax: Class::staticMethod
        int z = toDo(x, y, Service::tinhTong);
        System.out.println("1");
        System.out.println("Tổng của x và y là: " + z);
    }

    public static int toDo(int x, int y, Calculator cal) {
        System.out.println("2");
        return cal.timXY(x, y);
    }

}
