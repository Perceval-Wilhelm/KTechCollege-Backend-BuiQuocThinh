package Bai1;

abstract class Vehicle {
    // Init variables
    public String name;
    final int id;
    public static int vehicleCount = 0;

    // Constructor
    public Vehicle(int id) {
        this.id = id;
        vehicleCount++;
    }

    // Abstract method move
    public abstract void move();
}
