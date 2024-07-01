package Bai1;

public class Bike extends Vehicle {
    // Init variables
    private boolean hasGear;

    // Constructor
    public Bike (int id, boolean hasGear) {
        super(id);
        this.hasGear = hasGear;
    }

    @Override
    public void move() {
        System.out.println("Bike is moving");
    }

    // Getters and setters
    public boolean getHasGear() {
        return hasGear;
    }

    public void setHasGear(boolean hasGear) {
        this.hasGear = hasGear;
    }
}
