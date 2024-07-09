package vn.edu.likelion.day17;

import java.util.ArrayList;
import java.util.List;

public class testDistinct {
    public static void main(String[] args) {
        // Khởi tạo 1 danh sách ArrayList có 1 phần tử trùng lặp giá trị Java
        List<String> listDuplicate = new ArrayList<String>();
        listDuplicate.add("JAVA");
        listDuplicate.add("PHP");
        listDuplicate.add("JAVA");

        // Sử dụng distinct() để loại bỏ phần tử trùng
        List<String> listNonDuplicate = listDuplicate
                .stream()
                .distinct()
                .toList();
        System.out.println("ArrayList sau khi xoá phần tử trùng: " + listNonDuplicate);
    }
}
