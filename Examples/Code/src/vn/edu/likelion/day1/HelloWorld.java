package vn.edu.likelion.day1;

public class HelloWorld {

    /*
    Author: Tác giả
    Date: 17/6/2024
    Function: Ham chinh, chay dau tien
    Return: Khong trả về gì cả
     */
    public static void main(String[] agrs) {
        /*
        // comment 1 dòng
        // print, printf, println
        System.out.println("Hello World!");
        // đây là syntax đầu tiên cần học
        // chuột phải vào màn hình, chọn run vn.edu.likelion.day1.HelloWorld.main

        // Minh Nhựt đã thêm dòng này -- Start -- 18/6/2024
        System.out.println("đoạn chỉnh sửa");
        // Minh Nhựt đã thêm dòng này -- End

        // kiểu ký tự ''
        // chuỗi ký tự ""
        System.out.print("test/n");
        System.out.print("test2");

        // goi doi tuong vn.edu.likelion.day1.Tuan ra, khoi tao 1 doi tuong moi ten tuan
        vn.edu.likelion.day1.Tuan tuan = new vn.edu.likelion.day1.Tuan("vn.edu.likelion.day1.Tuan", 20);
        
        if (tuan.age == 19) {

        } else if (tuan.age == 21) {

        } else {

        }

        switch (tuan.age) {
            case 10:
                break;
            case 19:
                break;
            case 20:
                break;
            default:
                break;
        }

        int[] array = {1,2,3,4};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for(int i: array) {
            System.out.println(i);
        }

        while (tuan.age == 22) {
            tuan.age++;
            System.out.println("vn.edu.likelion.day1.Tuan age" + tuan.age);
        }

        do {
            System.out.println(tuan.age);
        } while (tuan.age == 21);

        vn.edu.likelion.day1.Tuan conCuaTuan = new vn.edu.likelion.day1.ConCuaTuan();
        conCuaTuan.anToi();


         */

        lopCon abc = new lopCon();
        System.out.println(abc.so());

    }

}
