package Bai2;

import Bai2.Model.ClassRoom;
import Bai2.Model.Student;
import Bai2.Model.Teacher;
import Bai2.Model.University;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        University university = new University();
        Scanner sc = new Scanner(System.in);

        addFakeData(university);

        while (true) {
            System.out.println("University Management System");
            System.out.println("1. Add ClassRoom to University");
            System.out.println("2. Add Student to University");
            System.out.println("3. Add Teacher to University");
            System.out.println("4. Add Student to ClassRoom");
            System.out.println("5. Show Student List in ClassRoom");
            System.out.println("6. Update Student Information");
            System.out.println("7. Student Drops Out");
            System.out.println("8. Show Dropped Students List");
            System.out.println("9. Show Students for Teacher");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    university.addClassRoomToUniversity();
                    break;
                case 2:
                    university.addStudentToUniversity();
                    break;
                case 3:
                    university.addTeacherToUniversity();
                    break;
                case 4:
                    university.addStudentToClassRoom();
                    break;
                case 5:
                    university.showStudentListInClassRoom();
                    break;
                case 6:
                    university.updateStudentInformation();
                    break;
                case 7:
                    university.studentDropsOut();
                    break;
                case 8:
                    university.showDroppedStudentsList();
                    break;
                case 9:
                    System.out.print("Enter Teacher ID: ");
                    int teacherId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    university.showStudentsForTeacher(teacherId);
                    break;
                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void addFakeData(University university) {
        // Add fake classrooms
        ClassRoom class1 = new ClassRoom("C1", "Math");
        ClassRoom class2 = new ClassRoom("C2", "Physics");
        ClassRoom class3 = new ClassRoom("C3", "Chemistry");

        university.getClassRooms().add(class1);
        university.getClassRooms().add(class2);
        university.getClassRooms().add(class3);

        // Add fake students
        Student student1 = new Student("Thinh", LocalDate.of(2003, 1, 10), 1);
        Student student2 = new Student("Toan", LocalDate.of(2004, 5, 15), 2);
        Student student3 = new Student("Tan", LocalDate.of(2003, 8, 20), 3);
        Student student4 = new Student("Kien", LocalDate.of(2004, 2, 25), 4);
        Student student5 = new Student("Hung", LocalDate.of(2003, 11, 30), 5);
        Student student6 = new Student("Phuc", LocalDate.of(2003, 12, 1), 6);
        Student student7 = new Student("Tinh", LocalDate.of(2004, 6, 10), 7);
        Student student8 = new Student("Vinh", LocalDate.of(2003, 3, 14), 8);
        Student student9 = new Student("Tuong", LocalDate.of(2004, 7, 22), 9);
        Student student10 = new Student("Nghia", LocalDate.of(2003, 9, 18), 10);

        student1.setStudentId("1_C1");
        student2.setStudentId("2_C1");
        student3.setStudentId("3_C1");
        student4.setStudentId("4_C1");
        student5.setStudentId("5_C1");
        student6.setStudentId("6_C1");
        student7.setStudentId("7_C1");
        student8.setStudentId("8_C1");
        student9.setStudentId("9_C1");
        student10.setStudentId("10_C1");

        student1.setStatus(true);
        student2.setStatus(true);
        student3.setStatus(true);
        student4.setStatus(true);
        student5.setStatus(true);
        student6.setStatus(true);
        student7.setStatus(true);
        student8.setStatus(true);
        student9.setStatus(true);
        student10.setStatus(true);

        university.getStudents().add(student1);
        university.getStudents().add(student2);
        university.getStudents().add(student3);
        university.getStudents().add(student4);
        university.getStudents().add(student5);
        university.getStudents().add(student6);
        university.getStudents().add(student7);
        university.getStudents().add(student8);
        university.getStudents().add(student9);
        university.getStudents().add(student10);

        // Add students to classrooms
        class1.addStudentId(student1.getStudentId());
        class1.addStudentId(student2.getStudentId());
        class1.addStudentId(student3.getStudentId());
        class1.addStudentId(student4.getStudentId());
        class1.addStudentId(student5.getStudentId());
        class1.addStudentId(student6.getStudentId());
        class1.addStudentId(student7.getStudentId());
        class1.addStudentId(student8.getStudentId());
        class1.addStudentId(student9.getStudentId());
        class1.addStudentId(student10.getStudentId());

        class2.addStudentId(student1.getStudentId());
        class2.addStudentId(student2.getStudentId());

        // Add fake teachers
        Teacher teacher1 = new Teacher("Mr. Tuan", 101, LocalDate.of(1980, 5, 20), 1);
        Teacher teacher2 = new Teacher("Mrs. Duong", 102, LocalDate.of(1975, 8, 10), 2);
        Teacher teacher3 = new Teacher("Ms. Brown", 103, LocalDate.of(1985, 3, 25), 3);

        teacher1.setClassIds(new ArrayList<>(List.of(1, 2)));
        teacher2.setClassIds(new ArrayList<>(List.of(2, 3)));
        teacher3.setClassIds(new ArrayList<>(List.of(1, 3)));

        university.getTeachers().add(teacher1);
        university.getTeachers().add(teacher2);
        university.getTeachers().add(teacher3);
    }
}
