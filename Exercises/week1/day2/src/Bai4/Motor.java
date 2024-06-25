package Bai4;

public class Motor extends Vehicle{
    public Motor(String name, double fuel, double distance, float speed) {
        super(name, fuel, distance, speed);
    }

    @Override
    public void model(String name) {
        System.out.println("Motorcycle model: " + name);
    }
}
