package Bai1;

public class Bicycle extends Vehicle{
    public Bicycle(float speed) {
        super(speed);
    }

    @Override
    public void SpeedUp(float speed) {
        System.out.println("Bicycle speed is: " + speed + " km/h");
    }
}
