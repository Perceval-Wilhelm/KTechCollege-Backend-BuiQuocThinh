package Bai1.Services;

import Bai1.Model.Student;

public interface StudentServices {
    void addStudentToSchool(Student student);
    void addStudentToCourse(int courseId, int studentId);
    Student findStudentById(int studentId);
    void showStudentInDetail(int courseId);
}
