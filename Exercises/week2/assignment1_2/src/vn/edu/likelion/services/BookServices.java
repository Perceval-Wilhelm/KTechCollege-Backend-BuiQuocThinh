package vn.edu.likelion.services;

import vn.edu.likelion.model.Book;

public interface BookServices {
    void addBook();
    void editBook();
    void removeBook(Book book);
    Book findBookById(int id);
    void showAllBook();
}
