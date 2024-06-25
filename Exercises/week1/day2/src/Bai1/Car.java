package Bai1;

public class Car extends Vehicle {
    public Car(float speed) {
        super(speed);
    }

    @Override
    public void SpeedUp(float speed) {
        System.out.println("Car speed is: " + speed + " km/h");
    }
}