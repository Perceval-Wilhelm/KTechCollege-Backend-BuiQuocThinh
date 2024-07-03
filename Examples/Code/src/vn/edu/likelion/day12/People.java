package vn.edu.likelion.day12;

import java.util.List;

public interface People <T> {
    void insert(T Object);
    void update (T Object);
    List<T> findAll();
    void remove(T Object);
}
