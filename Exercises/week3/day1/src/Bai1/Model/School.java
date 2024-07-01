package Bai1.Model;

import java.util.HashMap;
import java.util.Map;

public class ClassRoom {
    Map<Integer, Integer> hashMap = new HashMap<>();

    public ClassRoom(HashMap<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public ClassRoom() {}

    public Map<Integer, Integer> getHashMap() {
        return hashMap;
    }

    public void setHashMap(Map<Integer, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public void addCourseToStudent(int courseId) {
        
    }
}
