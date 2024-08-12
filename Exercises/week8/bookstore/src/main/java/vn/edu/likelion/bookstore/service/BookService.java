package vn.edu.likelion.bookstore.service;

import vn.edu.likelion.bookstore.entity.Book;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Optional;

public interface BookService extends BaseService<Book> {
    Iterator<Book> sortedByPrice();
    Iterator<Book> sortedBySold();
    Iterator<Object[]> getTotalSold();
    Iterator<Book> findByIdOrName(Integer id, String bookName);
    Iterator<Book> searchByDateRange(LocalDate startDate, LocalDate endDate);
    Iterator<Book> getTop5BestSellers();
}
