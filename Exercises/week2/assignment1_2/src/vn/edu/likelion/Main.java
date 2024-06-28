package vn.edu.likelion;

import vn.edu.likelion.model.Book;
import vn.edu.likelion.model.RentedBook;
import vn.edu.likelion.model.Renter;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Librarian librarian = new Librarian();

        while (true) {
            showMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    bookDetails(librarian, scanner);
                    break;
                case "2":
                    renterDetails(librarian, scanner);
                    break;
                case "3":
                    System.out.println("Thank you for using our library");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\nLibrary management system");
        System.out.println("1. Book details");
        System.out.println("2. Renter details");
        System.out.println("3. Exit");
    }

    private static void bookDetails(Librarian librarian, Scanner scanner) {
        while (true) {
            showBookMenu();
            String choiceBook = scanner.nextLine();

            switch (choiceBook) {
                case "1":
                    librarian.addBook();
                    break;
                case "2":
                    librarian.editBook();
                    break;
                case "3":
                    showAllBook(librarian);
                    break;
                case "4":
                    removeBook(librarian, scanner);
                    break;
                case "5":
                    System.out.println("Back to main menu");
                    return;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
    }

    private static void showBookMenu() {
        System.out.println("\nBook details");
        System.out.println("1. Add a new book");
        System.out.println("2. Edit a book");
        System.out.println("3. List all books");
        System.out.println("4. Delete a book");
        System.out.println("5. Back to main menu");
    }

    static void showEditBookMenu() {
        System.out.println("\nEdit book");
        System.out.println("1. Edit title");
        System.out.println("2. Edit author");
        System.out.println("3. Edit quantity");
        System.out.println("4. Back to main menu");
    }

    private static void showAllBook(Librarian librarian) {
        System.out.println("\nAll books");
        librarian.showAllBook();
    }

    private static void removeBook(Librarian librarian, Scanner scanner) {
        try {
            System.out.print("\nEnter ID of the book: ");
            int bookId = scanner.nextInt();

            Book book = librarian.findBookById(bookId);

            if (book != null) {
                librarian.removeBook(book);
                System.out.println("Book removed successfully.");
            }
            else {
                System.out.println("Book does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void renterDetails(Librarian librarian, Scanner scanner) {
        while (true) {
            showRentMenu();
            String choiceRent = scanner.nextLine();

            switch (choiceRent) {
                case "1":
                    addRenter(librarian, scanner);
                    break;
                case "2":
                    editRenterMenu(librarian, scanner);
                    break;
                case "3":
                    showAllRenter(librarian);
                    break;
                case "4":
                    rentBook(librarian, scanner);
                    break;
                case "5":
                    returnBook(librarian, scanner);
                    break;
                case "6":
                    System.out.println("Back to main menu");
                    return;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
    }

    private static void showRentMenu() {
        System.out.println("\nRent details");
        System.out.println("1. Add a new renter");
        System.out.println("2. Edit a renter");
        System.out.println("3. List all renters");
        System.out.println("4. Rent books");
        System.out.println("5. Return books");
        System.out.println("6. Back to main menu");
    }

    private static void addRenter(Librarian librarian, Scanner scanner) {
        try {
            System.out.print("\nEnter ID of the renter: ");
            int renterId = Integer.parseInt(scanner.nextLine());

            if (librarian.findRenterById(renterId) == null) {
                System.out.print("Enter renter name: ");
                String name = scanner.nextLine();

                System.out.print("Enter renter age: ");
                int age = Integer.parseInt(scanner.nextLine());

                librarian.addRenter(new Renter(renterId, name, age));
                System.out.println("Renter added successfully.");
            } else {
                System.out.println("Renter already exists.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editRenterMenu(Librarian librarian, Scanner scanner) {
        try {
            System.out.print("\nEnter ID of the renter: ");
            int renterId = Integer.parseInt(scanner.nextLine());
            Renter renter = librarian.findRenterById(renterId);

            if (renter != null) {
                showEditRenterMenu();
                String choiceEditRenter = scanner.nextLine();

                switch (choiceEditRenter) {
                    case "1":
                        editRenterName(librarian, scanner, renter, choiceEditRenter);
                        break;
                    case "2":
                        editRenterAge(librarian, scanner, renter, choiceEditRenter);
                        break;
                    case "3":
                        editRenterQuantity(librarian, scanner, renter, choiceEditRenter);
                        break;
                    case "4":
                        editRenterReturnDate(librarian, scanner, renter, choiceEditRenter);
                        break;
                    case "5":
                        changeBook(librarian, scanner, renter);
                        break;
                    case "6":
                        System.out.println("Back to renter menu");
                        return;
                    default:
                        System.out.println("Invalid input, please try again.");
                        break;
                }
            }
            else {
                System.out.println("Renter does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void showEditRenterMenu() {
        System.out.println("\nEdit renter");
        System.out.println("1. Edit name");
        System.out.println("2. Edit age");
        System.out.println("3. Edit quantity");
        System.out.println("4. Edit return date");
        System.out.println("5. Change book");
        System.out.println("6. Back to renter menu");
    }

    private static void editRenterName(Librarian librarian, Scanner scanner, Renter renter, String choiceEditRenter) {
        try {
            System.out.print("\nEnter new renter name: ");
            String name = scanner.nextLine();

            librarian.editRenter(renter, name, choiceEditRenter);

            System.out.println("Name edited successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editRenterAge(Librarian librarian, Scanner scanner, Renter renter, String choiceEditRenter) {
        try {
            System.out.print("\nEnter new renter age: ");
            String age = scanner.nextLine();

            librarian.editRenter(renter, age, choiceEditRenter);

            System.out.println("Age edited successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editRenterQuantity(Librarian librarian, Scanner scanner, Renter renter, String choiceEditRenter) {
        try {
            System.out.print("\nEnter book ID: ");
            int bookId = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter new quantity: ");
            String quantity = scanner.nextLine();

            System.out.println("Enter the rent frequency of the book: ");
            int rentFrequency = Integer.parseInt(scanner.nextLine());

            librarian.editBookOfRenter(renter, quantity, choiceEditRenter, bookId, rentFrequency);

            System.out.println("Quantity edited successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void editRenterReturnDate(Librarian librarian, Scanner scanner, Renter renter, String choiceEditRenter) {
        try {
            System.out.print("\nEnter book ID: ");
            int bookId = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter new time: ");
            String rentTime = scanner.nextLine();

            System.out.println("Enter the rent frequency of the book: ");
            int rentFrequency = Integer.parseInt(scanner.nextLine());

            librarian.editBookOfRenter(renter, rentTime, choiceEditRenter, bookId, rentFrequency);

            System.out.println("Return date edited successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void changeBook(Librarian librarian, Scanner scanner, Renter renter) {
        try {
            System.out.println("\n Change book.");
            System.out.println("1. Change books.");
            System.out.println("2. Back to renter menu.");

            String choiceChangeBook = scanner.nextLine();
            switch (choiceChangeBook) {
                case "1":
                    System.out.print("\nEnter ID of the book: ");
                    int bookId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter quantity per book: ");
                    int quantity = Integer.parseInt(scanner.nextLine());

                    System.out.println("Enter the rent frequency of the book: ");
                    int rentFrequency = Integer.parseInt(scanner.nextLine());

                    librarian.returnBookFromRenter(renter, bookId, quantity, rentFrequency);
                    try {
                        System.out.print("\nEnter ID of the book: ");
                        int newBookId = Integer.parseInt(scanner.nextLine());
                        Book newBook = librarian.findBookById(newBookId);

                        if (newBook != null) {
                            System.out.println("Rent date (yyyy-MM-dd): ");
                            String newDate = scanner.nextLine();
                            LocalDate newRentDate = LocalDate.parse(newDate);

                            System.out.println("Rent time (days): ");
                            int newTime = Integer.parseInt(scanner.nextLine());

                            System.out.println("Quantity: ");
                            int newQuantity = Integer.parseInt(scanner.nextLine());

                            System.out.println("Enter the rent frequency of the book: ");
                            int oldRentFrequency = Integer.parseInt(scanner.nextLine());

                            RentedBook rentedBook = librarian.findRentedBookByIdAfter(renter, bookId, oldRentFrequency);
                            if (rentedBook != null) {
                                int rentTimeOfBook = rentedBook.getRentFrequencyOfBook();
                                rentTimeOfBook = rentTimeOfBook + 1;
                                boolean add = librarian.addRentedBookToRenter(renter, newBook, newRentDate, newTime, newQuantity, rentTimeOfBook);
                                if (add) {
                                    System.out.println("Book added successfully.");
                                }
                                else {
                                    System.out.println("Book not added successfully.");
                                }
                            }
                            else {
                                boolean add = librarian.addRentedBookToRenter(renter, newBook, newRentDate, newTime, newQuantity, 0);
                                if (add) {
                                    System.out.println("Book added successfully.");
                                }
                                else {
                                    System.out.println("Book not added successfully.");
                                }
                            }
                        }
                        else {
                            System.out.println("Book not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                    break;
                case "2":
                    System.out.println("Back to renter menu");
                    return;
                }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void showAllRenter(Librarian librarian) {
        System.out.println("\nAll renters");
        librarian.showAllRenter();
    }

    private static void rentBook(Librarian librarian, Scanner scanner) {
        try {
            System.out.print("\nEnter ID of the renter: ");
            int renterId = Integer.parseInt(scanner.nextLine());
            Renter renter = librarian.findRenterById(renterId);

            if (renter != null) {
                System.out.println("\nRent book.");
                System.out.println("1. Add books.");
                System.out.println("2. Back to renter menu.");

                String choiceRentBook = scanner.nextLine();
                switch (choiceRentBook) {
                    case "1":
                        System.out.print("\nEnter ID of the book: ");
                        int bookId = Integer.parseInt(scanner.nextLine());
                        Book book = librarian.findBookById(bookId);

                        if (book != null) {
                            System.out.println("Rent date (yyyy-MM-dd): ");
                            String date = scanner.nextLine();
                            LocalDate rentDate = LocalDate.parse(date);

                            System.out.println("Rent time (days): ");
                            int time = Integer.parseInt(scanner.nextLine());

                            System.out.println("Quantity: ");
                            int quantity = Integer.parseInt(scanner.nextLine());

//                            System.out.println("Enter the rent frequency of the book: ");
//                            int oldRentFrequency = Integer.parseInt(scanner.nextLine());

                            RentedBook rentedBook = librarian.findRentedBookById(renter, bookId);
                            if (rentedBook != null) {
                                int rentTimeOfBook = rentedBook.getRentFrequencyOfBook();
                                rentTimeOfBook = rentTimeOfBook + 1;
                                boolean add = librarian.addRentedBookToRenter(renter, book, rentDate, time, quantity, rentTimeOfBook);
                                if (add) {
                                    System.out.println("Book added successfully.");
                                }
                                else {
                                    System.out.println("Book not added successfully.");
                                }
                            }
                            else {
                                boolean add = librarian.addRentedBookToRenter(renter, book, rentDate, time, quantity, 0);
                                if (add) {
                                    System.out.println("Book added successfully.");
                                }
                                else {
                                    System.out.println("Book not added successfully.");
                                }
                            }
                        }
                        else {
                            System.out.println("Book not found.");
                        }
                        break;
                    case "2":
                        System.out.println("Back to renter menu");
                        return;
                }
            }
            else {
                System.out.println("Renter does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    private static void returnBook(Librarian librarian, Scanner scanner) {
        try {
            System.out.print("\nEnter ID of the renter: ");
            int renterId = Integer.parseInt(scanner.nextLine());
            Renter renter = librarian.findRenterById(renterId);

            if (renter != null) {
                System.out.println("\nReturn book.");
                System.out.println("1. Return books.");
                System.out.println("2. Back to renter menu.");

                String choiceReturnBook = scanner.nextLine();
                switch (choiceReturnBook) {
                    case "1":
                        System.out.print("\nEnter ID of the book: ");
                        int bookId = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter quantity per book: ");
                        int quantity = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter the rent frequency of book: ");
                        int rentFrequency = Integer.parseInt(scanner.nextLine());

                        librarian.returnBookFromRenter(renter, bookId, quantity, rentFrequency);
                    case "2":
                        System.out.println("Back to renter menu");
                        return;
                }
            }
            else {
                System.out.println("Renter does not exist.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
