package vn.edu.likelion.model;

import java.time.LocalDate;

public class RentedBook {
    // Init variables
    private int id;
    private int rentQuantity;
    private LocalDate rentDate;
    private int rentTime;
    private LocalDate giveBackDate;
    private int rentFrequencyOfBook;

    // Constructor
    public RentedBook(int id, LocalDate rentDate, int rentTime, LocalDate giveBackDate, int rentQuantity, int rentFrequencyOfBook) {
        this.id = id;
        this.rentQuantity = rentQuantity;
        this.rentDate = rentDate;
        this.rentTime = rentTime;
        this.giveBackDate = giveBackDate;
        this.rentFrequencyOfBook = rentFrequencyOfBook;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRentQuantity() {
        return rentQuantity;
    }

    public void setRentQuantity(int rentQuantity) {
        this.rentQuantity = rentQuantity;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = LocalDate.now();
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public LocalDate getGiveBackDate() {
        return giveBackDate;
    }

    public void setGiveBackDate(LocalDate giveBackDate) {
        this.giveBackDate = giveBackDate;
    }

    public int getRentFrequencyOfBook() {
        return rentFrequencyOfBook;
    }

    public void setRentFrequencyOfBook(int rentFrequencyOfBook) {
        this.rentFrequencyOfBook = rentFrequencyOfBook;
    }

    @Override
    public String toString() {
        return "Rented book [id=" + id + ", rentDate=" + rentDate + ", rentTime=" + rentTime + ", giveBackDate=" + giveBackDate + ", rentQuantity=" + rentQuantity + ", rentFrequency=" + rentFrequencyOfBook + "]";
    }
}
