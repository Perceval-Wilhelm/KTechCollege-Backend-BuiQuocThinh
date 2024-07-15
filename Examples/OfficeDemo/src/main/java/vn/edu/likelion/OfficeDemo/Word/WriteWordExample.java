package vn.edu.likelion.OfficeDemo;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteWordExample {
    public static void main(String[] args) {
        // Tạo 1 file word
        XWPFDocument document = new XWPFDocument();

        // Tạo 1 đoạn văn bản
        XWPFParagraph paragraph = document.createParagraph();

        // Tạo câu văn
        XWPFRun run = paragraph.createRun();
        run.setText("Văn bản đầu tiên\n");
        run.setText("Được viết bằng java");

        try {
            // Tạo 1 file mới tên output.docx
            FileOutputStream fos = new FileOutputStream("output.docx");
            // Ghi các giá trị của document vào file
            document.write(fos);

            System.out.println("Đã tạo file docx thành công");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
