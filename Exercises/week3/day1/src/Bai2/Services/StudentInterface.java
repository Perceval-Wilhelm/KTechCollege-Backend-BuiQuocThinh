package Bai2.Services;

import Bai2.Model.Student;

public interface StudentInterface {
    void addStudentToUniversity();
    Student findStudentByStudentId(String studentId);
    Student findStudentById(int Id);
    void updateStudentInformation();
    void studentDropsOut();
    void showDroppedStudentsList();
}
