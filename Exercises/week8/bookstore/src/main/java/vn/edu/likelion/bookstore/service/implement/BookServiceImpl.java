package vn.edu.likelion.bookstore.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.likelion.bookstore.entity.Book;
import vn.edu.likelion.bookstore.repository.BookRepo;
import vn.edu.likelion.bookstore.service.BookService;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public Book create(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }

    @Override
    public void remove(Integer id) {
        Optional<Book> bookEntity = bookRepo.findById(id);
        if (bookEntity.isPresent()) {
            Book book = bookEntity.get();
            book.setIsDeleted(1);
            bookRepo.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    @Override
    public Iterator<Book> findAll() {
        return bookRepo.findAll().iterator();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepo.findById(id);
    }

    @Override
    public Iterator<Book> sortedByPrice() {
        List<Book> books = new ArrayList<>(bookRepo.findAll());
        books.sort(Comparator.comparingInt(Book::getPrice));
        return books.iterator();
    }

    @Override
    public Iterator<Book> sortedBySold() {
        List<Book> books = new ArrayList<>(bookRepo.findAll());
        books.sort(Comparator.comparingInt(Book::getSold).reversed());
        return books.iterator();
    }

    @Override
    public Iterator<Object[]> getTotalSold() {
        List<Book> books = new ArrayList<>(bookRepo.findAll());
        Map<String, Integer> totalSoldMap = new HashMap<>();
        for (Book book : books) {
            totalSoldMap.merge(book.getBook_name(), book.getSold(), Integer::sum);
        }
        List<Object[]> totalSoldList = totalSoldMap.entrySet().stream()
                .map(e -> new Object[]{e.getKey(), e.getValue()})
                .toList();
        return totalSoldList.iterator();
    }

    @Override
    public Iterator<Book> findByIdOrName(Integer id, String bookName) {
        List<Book> books = new ArrayList<>(bookRepo.findAll());
        List<Book> result = books.stream()
                .filter(book -> (id != null && book.getId()==id) ||
                        (book.getBook_name().equalsIgnoreCase(bookName)))
                .toList();
        return result.iterator();
    }

    @Override
    public Iterator<Book> searchByDateRange(LocalDate startDate, LocalDate endDate) {
        List<Book> books = new ArrayList<>(bookRepo.findAll());
        List<Book> result = books.stream()
                .filter(book -> !book.getCreateTime().isBefore(startDate) && !book.getCreateTime().isAfter(endDate))
                .toList();
        return result.iterator();
    }

    @Override
    public Iterator<Book> getTop5BestSellers() {
        List<Book> books = new ArrayList<>(bookRepo.findAll());
        List<Book> result = books.stream()
                .sorted(Comparator.comparingInt(Book::getSold).reversed())
                .limit(5)
                .toList();
        return result.iterator();
    }
}
