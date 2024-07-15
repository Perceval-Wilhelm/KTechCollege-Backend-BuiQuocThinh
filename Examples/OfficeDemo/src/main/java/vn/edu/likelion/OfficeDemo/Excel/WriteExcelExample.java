package vn.edu.likelion.OfficeDemo.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelExample {
    public static void main(String[] args) {
        // Tạo ra 1 đối tượng xử lý file excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Tạo ra 1 sheet mới từ workbook
        Sheet sheet = workbook.createSheet();

        // Tạo ra 1 row mới bên trong sheet
        Row row = sheet.createRow(0);

        // Tạo ra cell trong row
        Cell cell = row.createCell(0);
        cell.setCellValue("Lần đầu tiên đi học");
        Cell cell2 = row.createCell(1);
        cell2.setCellValue("Em mắt ướt nhạt nhoà");

        // Tạo ra 1 file excel vật lý
        try {
            FileOutputStream fos = new FileOutputStream("output.xlsx");
            workbook.write(fos);
            System.out.println("Đã tạo file xlsx thành công!");

            workbook.close();
            fos.close();
        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
