package Bai2.Services;

import Bai2.Model.ClassRoom;

public interface ClassRoomInterface {
    void addClassRoomToUniversity();
    ClassRoom findClassRoomById(String classRoomId);
    void addStudentToClassRoom();
    void showStudentListInClassRoom();
}
