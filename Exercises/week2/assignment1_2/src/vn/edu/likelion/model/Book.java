package vn.edu.likelion.model;

public class Book {
    // Define variables
    private int id;
    private String title;
    private String author;
    private int quantity;

    // Constructor
    public Book(int id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Convert to string
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", quantity=" + quantity + "]";
    }
}
