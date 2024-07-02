package Bai2.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Teacher extends People{
    // Init variebles
    private int teacherId;
    private ArrayList<Integer> classIds;

    // Constructor
    public Teacher(String name, int ID, LocalDate dateofBirth, int teacherId) {
        super(name, ID, dateofBirth);
        this.teacherId = teacherId;
    }

    // Getters and Setters
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public ArrayList<Integer> getClassIds() {
        return classIds;
    }

    public void setClassIds(ArrayList<Integer> classIds) {
        this.classIds = classIds;
    }
}
