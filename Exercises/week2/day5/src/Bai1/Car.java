package Bai1;

public class Car extends Vehicle {
    // Init variables
    private int numberOfDoors;

    // Constructor
    public Car(int id, int numberOfDoors) {
        super(id);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    // Getters and setters
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
