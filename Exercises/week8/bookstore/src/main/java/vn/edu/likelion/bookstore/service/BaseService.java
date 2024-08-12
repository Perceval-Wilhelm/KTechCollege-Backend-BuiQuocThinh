package vn.edu.likelion.bookstore.service;

import java.util.Iterator;
import java.util.Optional;

public interface BaseService<T> {
    T create(T t);
    T update(T t);
    void delete(T t);
    void remove(Integer id);
    Iterator<T> findAll();
    Optional<T> findById(Integer id);
}
