package Bai4;

public class Vehicle {
    String name;
    double fuel;
    double distance;
    float speed;

    public Vehicle(String name, double fuel, double distance, float speed) {
        this.name = name;
        this.fuel = fuel;
        this.distance = distance;
        this.speed = speed;
    }

    public void model(String name) {
        System.out.println("Vehicle model: " + name);
    }

    public void fuel_efficiency(double fuel) {
        System.out.println("Fuel efficiency: " + fuel + " gpm");
    }

    public void traveled(double distance) {
        System.out.println("Distance Traveled: " + distance + " miles");
    }

    public void max_speed(float speed) {
        System.out.println("Max Speed: " + speed + " mph");
    }

    public void fuel_consume(double fuel, double distance) {
        System.out.println("Fuel consumption: " + fuel * distance + " g");
    }
}
