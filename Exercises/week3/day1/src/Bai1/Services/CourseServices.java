package Bai1.Services;

import Bai1.Model.CourseOnline;

import java.util.ArrayList;

public interface CourseServices {
    void addCourseOnlineToCourse(CourseOnline course);
    default void showCourseOnlineInDetail() {
        System.out.println("Course Online");
    }
    CourseOnline findOnlineCourseById(int courseId);
    void showSpecificCourseOnlineInDetail();
    ArrayList<Integer> getCourse(int courseId);
}
