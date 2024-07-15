package vn.edu.likelion.OfficeDemo.PDF;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;
import java.io.IOException;

public class WritePDFExample {
    public static void main(String[] args) {
        try {
            // Tạo ra 1 đối tượng PDF
            PDDocument document = new PDDocument();

            // Tạo ra 1 trang từ đối tượng PDF trên
            PDPage page = new PDPage();

            // Tạo ra 1 cái lớp cho phép vẽ văn bản
            PDPageContentStream content = new PDPageContentStream(document, page);

            // set font và font size cho nội dung
            content.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 14);

            // Nội dung phải bọc bên trong beginText() và endText()
            content.beginText();
            // Kiểm tra toạ độ của page
            System.out.println(page.getBleedBox());
            content.newLineAtOffset(20, 772);
            content.showText("Hello World!");

            content.newLineAtOffset(0, -20);
            content.showText("Lo lo cc");
            content.endText();

            // Tạo ra file PDF vật lý
            File file = new File("output.pdf");

            document.addPage(page);
            content.close();
            document.save(file);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
