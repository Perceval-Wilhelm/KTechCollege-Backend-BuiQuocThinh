package vn.edu.likelion.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Renter {
    // Init variables
    private int id;
    private String name;
    private int age;
    private ArrayList<RentedBook> rentedBooks;

    // Constructor
    public Renter(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.rentedBooks = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<RentedBook> getRentedBooks() {
        return rentedBooks;
    }

    public void setBooks(ArrayList<RentedBook> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public void addRentedBook(Book book, LocalDate rentDate, int time, int quantity, int rentFrequency) {
        LocalDate giveBackDate = rentDate.plusDays(time);
        RentedBook rentedBook = new RentedBook(book.getId(), rentDate, time, giveBackDate, quantity, rentFrequency);
        rentedBooks.add(rentedBook);
    }

    // Convert to string
    @Override
    public String toString() {
        return "Renter [id=" + id + ", name=" + name + ", age=" + age + ", rentedBook=" + rentedBooks + "]";
    }
}
