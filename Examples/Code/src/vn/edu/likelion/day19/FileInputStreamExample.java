package vn.edu.likelion.day19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        // Đường dẫn và tên file cần đọc
        // Không có đường dẫn thì nó sẽ tự tìm trong folder bên ngoài project
        // Nếu file này không tồn tại thì sẽ bị FileNotFoundException
        String sourceFile = "Class3.txt";

        // Tạo 1 cái đối tượng FileInputStream
        FileInputStream fis = null;
        try {
            // Tạo 1 cái instance của FileInputStream với tên file là Class3
            fis =  new FileInputStream(sourceFile);

            byte[] content = new byte[1024];
            int byteRead;
            // Ghi nội dung trong file ra màn hình console
            while((byteRead = fis.read(content)) != -1) {
                System.out.println(new String(content, 0, byteRead));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException io1) {
            io1.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException io2) {
                io2.printStackTrace();
            }
        }
    }
}
