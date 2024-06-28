package vn.edu.likelion;

import vn.edu.likelion.model.Book;
import vn.edu.likelion.model.RentedBook;
import vn.edu.likelion.model.Renter;
import vn.edu.likelion.services.BookServices;
import vn.edu.likelion.services.RenterServices;

import java.time.LocalDate;
import java.util.ArrayList;

import static vn.edu.likelion.Main.scanner;
import static vn.edu.likelion.Main.showEditBookMenu;

public class Librarian implements BookServices, RenterServices {
    // Init variables
    private ArrayList<Book> books;
    private ArrayList<Renter> renters;

    // Constructor
    public Librarian() {
        books = new ArrayList<>();
        renters = new ArrayList<>();
    }

    // Getters and Setters
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Renter> getRenters() {
        return renters;
    }

    public void setRenters(ArrayList<Renter> renters) {
        this.renters = renters;
    }

    @Override
    public void addBook() {
        try {
            System.out.print("\nEnter ID of the book: ");
            int bookId = Integer.parseInt(scanner.nextLine());

            if (findBookById(bookId) == null) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();

                System.out.print("Enter author name: ");
                String author = scanner.nextLine();

                System.out.print("Enter quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine());

                books.add(new Book(bookId, title, author, quantity));
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Book already exists.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    @Override
    public void editBook() {
        try {
            System.out.print("\nEnter ID of the book: ");
            int bookId = Integer.parseInt(scanner.nextLine());
            Book book = findBookById(bookId);

            if (book != null) {
                showEditBookMenu();
                String choiceEditBook = scanner.nextLine();
                switch (choiceEditBook) {
                    case "1":
                        try {
                            System.out.print("\nEnter new book title: ");
                            String title = scanner.nextLine();

                            book.setTitle(title);

                            System.out.println("Title edited successfully.");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    case "2":
                        try {
                            System.out.print("\nEnter new book author: ");
                            String author = scanner.nextLine();

                            book.setTitle(author);

                            System.out.println("Author edited successfully.");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    case "3":
                        try {
                            System.out.print("\nEnter new book quantity: ");
                            String quantity = scanner.nextLine();

                            book.setQuantity(Integer.parseInt(quantity));

                            System.out.println("Quantity edited successfully.");
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                        }
                        break;
                    case "4":
                        System.out.println("Back to main menu");
                        return;
                    default:
                        System.out.println("Invalid choice, please try again");
                        break;
                }
            }
            else {
                System.out.println("Book does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public void addRenter(Renter renter) {
        renters.add(renter);
    }

    @Override
    public void editRenter(Renter renter, String edit, String choiceEditRenter) {
        switch (choiceEditRenter) {
            case "1":
                renter.setName(edit);
                break;
            case "2":
                renter.setAge(Integer.parseInt(edit));
                break;
        }
    }

    public void editBookOfRenter(Renter renter, String edit, String choiceEditRenter, int bookId, int rentFrequency) {
        switch (choiceEditRenter) {
            case "3":
                RentedBook rentedBook = findRentedBookByIdAfter(renter, bookId, rentFrequency);
                if (rentedBook != null) {
                    rentedBook.setRentQuantity(Integer.parseInt(edit));
                }
            case "4":
                RentedBook rentedBook2 = findRentedBookByIdAfter(renter, bookId, rentFrequency);
                if (rentedBook2 != null) {
                    rentedBook2.setRentTime(Integer.parseInt(edit));
                    rentedBook2.setGiveBackDate(rentedBook2.getRentDate().plusDays(Integer.parseInt(edit)));
                }
        }
    }

    @Override
    public void removeRenter(Renter renter) {
        renters.remove(renter);
    }

    @Override
    public Renter findRenterById(int id) {
        for (Renter renter : renters) {
            if (renter.getId() == id) {
                return renter;
            }
        }
        return null;
    }

    @Override
    public void showAllRenter() {
        for (Renter renter : renters) {
            System.out.println(renter.toString());
        }
    }

    @Override
    public void showAllBook() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public boolean addRentedBookToRenter(Renter renter, Book book, LocalDate rentDate, int time, int quantity, int rentFrequency) {
        if (renter.getAge() > 16) {
            if (quantity > book.getQuantity()) {
                System.out.println("Not enough books for the renter");
                return false;
            }
            else {
                renter.addRentedBook(book, rentDate, time, quantity, rentFrequency);
                book.setQuantity(book.getQuantity() - quantity);
            }
        } else {
            System.out.println("Renter must be at least 17 years old.");
        }
        return true;
    }

    public RentedBook findRentedBookById(Renter renter, int bookId) {
        for (RentedBook rentedBook : renter.getRentedBooks()) {
            if (rentedBook.getId() == bookId) {
                return rentedBook;
            }
        }
        return null;
    }

    public RentedBook findRentedBookByIdAfter(Renter renter, int bookId, int rentFrequency) {
        for (RentedBook rentedBook : renter.getRentedBooks()) {
            if (rentedBook.getId() == bookId && rentedBook.getRentFrequencyOfBook() == rentFrequency) {
                return rentedBook;
            }
        }
        return null;
    }

    public void returnBookFromRenter(Renter renter, int bookId, int quantity, int rentFrequency) {
        RentedBook rentedBook = findRentedBookByIdAfter(renter, bookId, rentFrequency);
        if (rentedBook != null) {
            Book book = findBookById(bookId);
            if (rentedBook.getRentQuantity() == quantity) {
                renter.getRentedBooks().remove(rentedBook);
                book.setQuantity(book.getQuantity() + quantity);
            } else if (rentedBook.getRentQuantity() < quantity) {
                renter.getRentedBooks().remove(rentedBook);
                int bookExceed = quantity - book.getQuantity();
                book.setQuantity(book.getQuantity() + quantity);
                System.out.println("Exceed " + bookExceed + " books from the renter");
            } else {
                renter.getRentedBooks().remove(rentedBook);
                int bookMissing = quantity - book.getQuantity();
                book.setQuantity(book.getQuantity() - quantity);
                System.out.println("Missing " + bookMissing + " books from the renter");
            }
        }
        else {
            System.out.println("Book not found.");
        }
    }
}
