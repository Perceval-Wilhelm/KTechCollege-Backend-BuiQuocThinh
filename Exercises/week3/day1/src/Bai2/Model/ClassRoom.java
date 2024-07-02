package Bai2.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClassRoom {
    // Init variables
    private String classId;
    private String className;
    private LocalDate classStart;
    private ArrayList<String> studentIds;

    // Constructor
    public ClassRoom(String classId, String className) {
        this.classId = classId;
        this.className = className;
        this.studentIds = new ArrayList<>();
    }

    // Getters and Setters
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public LocalDate getClassStart() {
        return classStart;
    }

    public void setClassStart(LocalDate classStart) {
        this.classStart = classStart;
    }

    public ArrayList<String> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(ArrayList<String> studentIds) {
        this.studentIds = studentIds;
    }

    public void addStudentId(String studentId) {
        this.studentIds.add(studentId);
    }
}
