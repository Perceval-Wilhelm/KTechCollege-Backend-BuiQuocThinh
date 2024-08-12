package vn.edu.likelion.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.bookstore.dto.request.BookRequestDTO;
import vn.edu.likelion.bookstore.dto.request.StockRequestDTO;
import vn.edu.likelion.bookstore.dto.response.BookResponseDTO;
import vn.edu.likelion.bookstore.dto.response.StockResponseDTO;
import vn.edu.likelion.bookstore.entity.Book;
import vn.edu.likelion.bookstore.entity.History;
import vn.edu.likelion.bookstore.entity.User;
import vn.edu.likelion.bookstore.service.BookService;
import vn.edu.likelion.bookstore.service.HistoryService;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private HistoryService historyService;

    // Create a new book
    @PostMapping("/create")
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setBook_name(bookRequestDTO.getBook_name());
        book.setAuthor(bookRequestDTO.getAuthor());
        book.setPrice(bookRequestDTO.getPrice());
        book.setQuantity(bookRequestDTO.getQuantity());

        Book createdBook = bookService.create(book);
        return new ResponseEntity<>(convertToResponseDTO(createdBook), HttpStatus.CREATED);
    }

    // Update an existing book
    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Integer id, @RequestBody BookRequestDTO bookRequestDTO) {
        Optional<Book> existingBook = bookService.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setBook_name(bookRequestDTO.getBook_name());
            book.setAuthor(bookRequestDTO.getAuthor());
            book.setPrice(bookRequestDTO.getPrice());
            book.setQuantity(bookRequestDTO.getQuantity());

            Book updatedBook = bookService.update(book);
            return new ResponseEntity<>(convertToResponseDTO(updatedBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a book
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        Optional<Book> existingBook = bookService.findById(id);
        if (existingBook.isPresent()) {
            bookService.delete(existingBook.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Soft delete a book (mark as deleted)
    @PutMapping("/remove/{id}")
    public ResponseEntity<Void> removeBook(@PathVariable Integer id) {
        Optional<Book> existingBook = bookService.findById(id);
        if (existingBook.isPresent()) {
            bookService.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all books
    @GetMapping("/findAll")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        Iterator<Book> books = bookService.findAll();
        List<BookResponseDTO> bookResponseDTOs = new ArrayList<>();
        while (books.hasNext()) {
            bookResponseDTOs.add(convertToResponseDTO(books.next()));
        }
        return new ResponseEntity<>(bookResponseDTOs, HttpStatus.OK);
    }

    // Get a book by ID
    @GetMapping("/findById/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Integer id) {
        Optional<Book> book = bookService.findById(id);
        return book.map(value -> new ResponseEntity<>(convertToResponseDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Stock in
    @PostMapping("/stockIn")
    public ResponseEntity<StockResponseDTO> stockInBook(@RequestBody StockRequestDTO stockInRequestDTO) {
        Book book = bookService.findById(stockInRequestDTO.getBook_id()).get();

        int pre_quantity = book.getQuantity();
        int quantity_stock = stockInRequestDTO.getQuantity_stock();
        int after_quantity = quantity_stock + pre_quantity;

        book.setQuantity(after_quantity);
        book.setUpdateTime(LocalDate.now());
        bookService.update(book);

        User user = new User();
        user.setId(10);

        History history = new History();
        history.setBook(book);
        history.setUser(user);
        history.setQuantity(stockInRequestDTO.getQuantity_stock());
        history.setType(0);
        historyService.create(history);

        return new ResponseEntity<>(convertToStockResponseDTO(history, book, pre_quantity, after_quantity, quantity_stock), HttpStatus.CREATED);
    }

    // Stock out
    @PostMapping("/stockOut")
    public ResponseEntity<StockResponseDTO> stockOutBook(@RequestBody StockRequestDTO stockOutRequestDTO) {
        Book book = bookService.findById(stockOutRequestDTO.getBook_id()).get();

        int pre_quantity = book.getQuantity();
        int quantity_stock = stockOutRequestDTO.getQuantity_stock();
        if (quantity_stock > pre_quantity) {
            return null;
        }
        int after_quantity = pre_quantity - quantity_stock;

        book.setSold(pre_quantity + quantity_stock);
        book.setQuantity(after_quantity);
        book.setUpdateTime(LocalDate.now());
        bookService.update(book);

        User user = new User();
        user.setId(10);

        History history = new History();
        history.setBook(book);
        history.setUser(user);
        history.setQuantity(stockOutRequestDTO.getQuantity_stock());
        history.setType(1);
        historyService.create(history);

        return new ResponseEntity<>(convertToStockResponseDTO(history, book, pre_quantity, after_quantity, quantity_stock), HttpStatus.CREATED);
    }

    // Sort By Price
    @GetMapping("/sortedByPrice")
    public ResponseEntity<List<BookResponseDTO>> sortedByPrice() {
        Iterator<Book> books = bookService.sortedByPrice();
        List<BookResponseDTO> bookResponseDTOs = new ArrayList<>();
        books.forEachRemaining(book -> bookResponseDTOs.add(convertToResponseDTO(book)));
        return new ResponseEntity<>(bookResponseDTOs, HttpStatus.OK);
    }

    // Sort By Sold
    @GetMapping("/sortedBySold")
    public ResponseEntity<List<BookResponseDTO>> sortedBySold() {
        Iterator<Book> books = bookService.sortedBySold();
        List<BookResponseDTO> bookResponseDTOs = new ArrayList<>();
        books.forEachRemaining(book -> bookResponseDTOs.add(convertToResponseDTO(book)));
        return new ResponseEntity<>(bookResponseDTOs, HttpStatus.OK);
    }

    // Get total sold
    @GetMapping("/totalSold")
    public ResponseEntity<List<Map<String, Object>>> totalSold() {
        Iterator<Object[]> totalSoldQuantities = bookService.getTotalSold();
        List<Map<String, Object>> response = new ArrayList<>();
        totalSoldQuantities.forEachRemaining(obj -> {
            Map<String, Object> map = new HashMap<>();
            map.put("bookName", obj[0]);
            map.put("totalSoldQuantity", obj[1]);
            response.add(map);
        });
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Search By Id or Name
    @GetMapping("/findByIdOrName")
    public ResponseEntity<List<BookResponseDTO>> findByIdOrName(@RequestParam(required = false) Integer id,
                                                             @RequestParam(required = false) String bookName) {
        Iterator<Book> books = bookService.findByIdOrName(id, bookName);
        List<BookResponseDTO> bookResponseDTOs = new ArrayList<>();
        books.forEachRemaining(book -> bookResponseDTOs.add(convertToResponseDTO(book)));
        return new ResponseEntity<>(bookResponseDTOs, HttpStatus.OK);
    }

    // Search books by date range
    @GetMapping("/findByDateRange")
    public ResponseEntity<List<BookResponseDTO>> findByDateRange(@RequestParam LocalDate startDate,
                                                                 @RequestParam LocalDate endDate) {
        Iterator<Book> books = bookService.searchByDateRange(startDate, endDate);
        List<BookResponseDTO> bookResponseDTOs = new ArrayList<>();
        books.forEachRemaining(book -> bookResponseDTOs.add(convertToResponseDTO(book)));
        return new ResponseEntity<>(bookResponseDTOs, HttpStatus.OK);
    }

    // Get top 5 best sellers
    @GetMapping("/top5BestSellers")
    public ResponseEntity<List<BookResponseDTO>> getTop5BestSellers() {
        Iterator<Book> books = bookService.getTop5BestSellers();
        List<BookResponseDTO> bookResponseDTOs = new ArrayList<>();
        books.forEachRemaining(book -> bookResponseDTOs.add(convertToResponseDTO(book)));
        return new ResponseEntity<>(bookResponseDTOs, HttpStatus.OK);
    }

    private BookResponseDTO convertToResponseDTO(Book book) {
        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setBook_id(book.getId());
        bookResponseDTO.setBook_name(book.getBook_name());
        bookResponseDTO.setAuthor(book.getAuthor());
        bookResponseDTO.setPrice(book.getPrice());
        bookResponseDTO.setQuantity(book.getQuantity());
        bookResponseDTO.setSold(book.getSold());
        return bookResponseDTO;
    }

    private StockResponseDTO convertToStockResponseDTO(History history, Book book, int pre_quantity, int after_quantity, int quantity_stock) {
        StockResponseDTO stockResponseDTO = new StockResponseDTO();

        stockResponseDTO.setBook_id(history.getBook().getId());
        stockResponseDTO.setCreateTime(history.getBook().getCreateTime());
        stockResponseDTO.setBook_name(history.getBook().getBook_name());
        stockResponseDTO.setAuthor(history.getBook().getAuthor());
        stockResponseDTO.setPrice(history.getBook().getPrice());
        stockResponseDTO.setPre_quantity(pre_quantity);
        stockResponseDTO.setQuantity_stock(quantity_stock);
        stockResponseDTO.setAfter_quantity(after_quantity);
        stockResponseDTO.setType(history.getType()==1 ? "Stock out" : "Stock in");
        stockResponseDTO.setSold(book.getSold());
        return stockResponseDTO;
    }
}
