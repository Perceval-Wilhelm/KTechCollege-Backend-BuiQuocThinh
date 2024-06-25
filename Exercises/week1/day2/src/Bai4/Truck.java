package Bai4;

public class Truck extends Vehicle {
    public Truck(String name, double fuel, double distance, float speed) {
        super(name, fuel, distance, speed);
    }

    @Override
    public void model(String name) {
        System.out.println("Truck model: " + name);
    }
}
