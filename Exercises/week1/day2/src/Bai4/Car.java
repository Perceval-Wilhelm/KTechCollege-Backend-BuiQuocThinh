package Bai4;

public class Car extends Vehicle {
    public Car(String name, double fuel, double distance, float speed) {
        super(name, fuel, distance, speed);
    }

    @Override
    public void model(String name) {
        System.out.println("Car model: " + name);
    }
}
