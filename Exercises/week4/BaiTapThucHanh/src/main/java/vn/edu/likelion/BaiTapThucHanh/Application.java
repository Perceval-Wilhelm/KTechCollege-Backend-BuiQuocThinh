package vn.edu.likelion.BaiTapThucHanh;

import java.util.Base64;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String fileA = "StudentsList.txt";

        ArrayList<Student> students = readStudentsFromFile(fileA);

        ArrayList<Student> presentStudents = new ArrayList<>();
        ArrayList<Student> absentStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.isPresent()) {
                presentStudents.add(student);
            } else {
                absentStudents.add(student);
            }
        }

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDateTime = currentDate.format(formatter);

        String excelFileName = STR."PresentStudents_\{formattedDateTime}.xlsx";
        String wordFileName = STR."AbsentStudents_\{formattedDateTime}.docx";

        writeExcel(presentStudents, excelFileName);
        writeWord(absentStudents, wordFileName);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to display present students in Excel and 2 to display absent students in Word");
        String sc = scanner.nextLine();
        try {
            if (sc.equals("1")) {
                displayExcelFileContent(excelFileName);
            } else if (sc.equals("2")) {
                displayWordFileContent(wordFileName);
            }
        } catch (Exception e) {
            System.err.println("Invalid input");
        }
    }

    private static ArrayList<Student> readStudentsFromFile(String fileName) {
        ArrayList<Student> students = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader readFileA = null;

        try {
            fileReader = new FileReader(fileName);
            readFileA = new BufferedReader(fileReader);

            String line;
            System.out.println("Buffered Reader start reading...");

            while ((line = readFileA.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    boolean isPresent = parts[2].equals("0");
                    students.add(new Student(id, name, isPresent));
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (readFileA != null) {
                    readFileA.close();
                }
                System.out.println("Read successfully");
            } catch (IOException io2) {
                io2.printStackTrace();
            }
        }
        return students;
    }

    private static void writeExcel(ArrayList<Student> presentStudents, String excelFileName) {
        try {
            FileInputStream fis = new FileInputStream("output.xlsx");

            Workbook workbook = new XSSFWorkbook(fis);

            Sheet sheet = workbook.getSheetAt(0);

            int rowIndex = 4;
            for (Student student : presentStudents) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) {
                    row = sheet.createRow(rowIndex);
                }
                Cell cell1 = row.createCell(1);
                cell1.setCellValue(Base64.getEncoder().encodeToString(student.getName().getBytes()));
                rowIndex++;
            }
            try (FileOutputStream fileOut = new FileOutputStream(excelFileName)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeWord(ArrayList<Student> absentStudents, String wordFileName) {
        try (XWPFDocument document = new XWPFDocument()) {
            int count = 1;
            for (Student student : absentStudents) {
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setText(STR."\{count}\t\{Base64.getEncoder().encodeToString(student.getName().getBytes())}");
                count++;
            }

            try (FileOutputStream fileOut = new FileOutputStream(wordFileName)) {
                document.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayExcelFileContent(String filePath) {
        Pattern base64Pattern = Pattern.compile("^[A-Za-z0-9+/=]+$");

        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            String cellValue = cell.getStringCellValue();
                            if (base64Pattern.matcher(cellValue).matches()) {
                                System.out.println(decodeBase64(cellValue));
                            } else {
                                System.out.println(cellValue);
                            }
                            break;
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                        case FORMULA:
                            System.out.println(cell.getCellFormula());
                            break;
                        case BOOLEAN:
                            System.out.println(cell.getBooleanCellValue());
                            break;
                        case ERROR:
                            System.out.println(cell.getErrorCellValue());
                            break;
                        case BLANK:
                            System.out.println(cell.getCellComment());
                            break;
                        default:
                            System.out.println(cell.getDateCellValue());
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayWordFileContent(String filePath) {
        Pattern base64Pattern = Pattern.compile("^[A-Za-z0-9+/=]+$");

        File file = new File(filePath);
        try {
            InputStream input = new FileInputStream(file);
            XWPFDocument document = new XWPFDocument(input);

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                String paragraphText = paragraph.getText();
                String[] parts = paragraphText.split("\t");
                for (String part : parts) {
                    if (base64Pattern.matcher(part).matches()) {
                        System.out.print(STR."\{decodeBase64(part)}\t");
                    } else {
                        System.out.print(STR."\{part}\t");
                    }
                }
                System.out.println();
            }

            document.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String decodeBase64(String input) {
        return new String(Base64.getDecoder().decode(input));
    }
}
