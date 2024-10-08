package vn.edu.likelion.assignment2jpa2.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public interface BaseService<T> {
    T create(T t);
    T update(T t);
    void delete(T t);
    Iterator<T> findAll();
    Optional<T> findById(int id);
}
