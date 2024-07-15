package vn.edu.likelion.day19;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        // Đường dẫn đến file đích
        String filename = "Class3.txt";
        String content = "Hello Class 3";

        // Khởi tạo đối tượng từe class FileOutputStream
        FileOutputStream fos = null;
        try {
            // Tạo ra 1 instance với tên file laf Class3.txt
            // File này không có đường dẫn nên sẽ được tạo trong project
            fos = new FileOutputStream(filename);
            // Ghi nội dung content vào file
            fos.write(content.getBytes());
            System.out.println("Đã tạo và ghi file thành công");
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                // Phải close cái FileOutputStream
                // Cái này là rất quan trọng
                fos.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
