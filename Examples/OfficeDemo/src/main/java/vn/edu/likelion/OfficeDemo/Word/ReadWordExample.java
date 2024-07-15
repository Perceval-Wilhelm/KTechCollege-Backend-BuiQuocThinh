package vn.edu.likelion.OfficeDemo;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.*;

public class ReadWordExample {
    public static void main(String[] args) {
        // Đọc file vật lý
        File file = new File("output.docx");

        try {
            InputStream input = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(input);

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                System.out.println(paragraph.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
