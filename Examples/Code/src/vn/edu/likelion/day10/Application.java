package vn.edu.likelion.day10;

public class Application {

    // khai bao 1 bien static final
    static final int ab;

    static {
        ab= 123456;
    }

    public static void main(String[] agrs) {

        // Khởi tạo 1 object từ constructor mặc định
        Student stu = new Student();

        // Khởi tạo 1 object từ constructor tham số là tên
        Student stu2 = new Student("Tấn");

        // Khởi tạo 1 object từ constructor tham số là tuổi
        Student st3 = new Student(18);

        // Khởi tạo 1 object từ constructor có 2 tham số trên
        Student st4 = new Student("Kiên", 20);

        // dung object stu de thay doi gia tri cua id
        //stu.id = 123123;

        // khai bao 1 datatype de tai su dung bien id
        int cccd = stu.id;

    }
}
