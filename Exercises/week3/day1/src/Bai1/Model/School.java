package Bai1.Model;

import Bai1.Services.CourseServices;
import Bai1.Services.StudentServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class School implements CourseServices, StudentServices {
    HashMap<Integer, ArrayList<Integer>> hashMapCourse = new HashMap<>();
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<CourseOnline> courseOnlineList = new ArrayList<>();

    public HashMap<Integer, ArrayList<Integer>> getHashMapCourse() {
        return hashMapCourse;
    }

    public void setHashMapCourse(HashMap<Integer, ArrayList<Integer>> hashMapCourse) {
        this.hashMapCourse = hashMapCourse;
    }

    public void addCourseOnlineToCourse(CourseOnline course) {
        courseOnlineList.add(course);
    }

    @Override
    public void showCourseOnlineInDetail() {
        for (Course i : courseOnlineList) {
            i.showCourseInDetail();
        }
    }

    public CourseOnline findOnlineCourseById(int courseId) {
        for (CourseOnline courseOnline : courseOnlineList) {
            if (courseOnline.getCourseId() == courseId) {
                return courseOnline;
            }
        }
        return null;
    }

    public void showSpecificCourseOnlineInDetail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Course ID: :");
        int courseId = sc.nextInt();

        CourseOnline courseOnline = findOnlineCourseById(courseId);
        courseOnline.showCourseInDetail();
    }

    public void addStudentToSchool(Student student) {
        studentList.add(student);
    }

    public void addStudentToCourse(int courseId, int studentId) {
        if (!hashMapCourse.containsKey(courseId)) {
            ArrayList<Integer> studentIds = new ArrayList<>();
            studentIds.add(studentId);
            hashMapCourse.put(courseId, studentIds);
        } else {
            ArrayList<Integer> studentIds = hashMapCourse.get(courseId);
            if (!studentIds.contains(studentId)) {
                studentIds.add(studentId);
            }
        }
    }

    public ArrayList<Integer> getCourse(int courseId) {
        ArrayList<Integer> studentIds = hashMapCourse.get(courseId);
        if (studentIds != null) {
            return studentIds;
        } else {
            System.out.println("Course " + courseId + " does not exist.");
        }
        return null;
    }

    public Student findStudentById(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public void showStudentInDetail(int courseId){
        ArrayList<Integer> studentIds = getCourse(courseId);
        for (Integer i : studentIds) {
            Student student = findStudentById(i);
            student.showStudentDetail();
        }
    }
}
