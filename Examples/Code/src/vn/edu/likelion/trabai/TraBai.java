package vn.edu.likelion.trabai;

import java.util.Random;

public class TraBai {
    public static void main(String[] args) {
        Random ran = new Random();

        DanhSachHV ds = new DanhSachHV();
        System.out.println(ds.layDanhSachHV().get(ran.nextInt(23)));
    }
}
