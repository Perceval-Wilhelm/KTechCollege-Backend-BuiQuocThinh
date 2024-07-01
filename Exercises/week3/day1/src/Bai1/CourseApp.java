package Bai1;

import Bai1.Model.CourseOnline;
import Bai1.Model.School;
import Bai1.Model.Student;

public class CourseApp {
    public static void main(String[] args) {
        School school = new School();

        CourseOnline course1 = new CourseOnline(1, "Mathematics", "Ngo Bao Chau", 4, "Google Meet", 4);
        CourseOnline course2 = new CourseOnline(2, "Physics", "Stephen Hawking", 4, "Microsoft Teams", 5);
        CourseOnline course3 = new CourseOnline(3, "Literature", "Nguyen Nhat Anh", 4, "Zoom", 6);

        Student student1 = new Student(1, "Bui Quoc Thinh", 22, "Male", "Computer Science");
        Student student2 = new Student(2, "Nguyen Ha Kien", 33, "Female", "Information Technology");
        Student student3 = new Student(3, "Alex Sawer Hoang Dat", 44, "Male", "Artificial Intelligence");

        school.addCourseOnlineToCourse(course1);
        school.addCourseOnlineToCourse(course2);
        school.addCourseOnlineToCourse(course3);
        System.out.println("\nCourse Online List:");
        school.showCourseOnlineInDetail();

        school.addStudentToSchool(student1);
        school.addStudentToSchool(student2);
        school.addStudentToSchool(student3);

        school.addStudentToCourse(1, 1);
        school.addStudentToCourse(1, 2);
        school.addStudentToCourse(2, 1);
        school.addStudentToCourse(2, 3);
        System.out.println("\nStudents of course 1:");
        school.showStudentInDetail(1);

        System.out.println("\nStudents of course 2:");
        school.showStudentInDetail(2);

        System.out.println("\nShow a specific course online detail:");
        school.showSpecificCourseOnlineInDetail();
    }
}
