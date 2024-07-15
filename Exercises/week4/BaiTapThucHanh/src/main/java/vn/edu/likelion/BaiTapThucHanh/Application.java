package vn.edu.likelion.BaiTapThucHanh;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String fileA = "StudentsList.txt";

        List<Student> students = readStudentsFromFile(fileA);

        List<Student> presentStudents = new ArrayList<>();
        List<Student> absentStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.isPresent()) {
                presentStudents.add(student);
            }
            else {
                absentStudents.add(student);
            }
        }

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        String formattedDateTime = currentDate.format(formatter);

        writeExcel(students, formattedDateTime);
    }

    private static List<Student> readStudentsFromFile(String fileName) {
        List<Student> students = new ArrayList<>();

        FileReader fileReader = null;
        BufferedReader readFileA = null;

        try {
            fileReader = new FileReader(fileName);
            readFileA = new BufferedReader(fileReader);

            String line = readFileA.readLine();
            System.out.println("Buffered Reader start reading...");

            while (line != null) {
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
                fileReader.close();
                readFileA.close();
                System.out.println("Read successfully");
            } catch (IOException io2) {
                io2.printStackTrace();
            }
        }
        return students;
    }

    private static void writeExcel(List<Student> presentStudents, String formattedDateTime) {
        String excelFileName = "PresentStudents_" + formattedDateTime + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
    }
}
