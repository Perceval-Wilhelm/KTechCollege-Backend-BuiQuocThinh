package Bai1;

public class Vehicle {
    float speed;

    public Vehicle(float speed) {
        this.speed = speed;
    }

    public void SpeedUp(float speed){
        System.out.println("Average speed is: " + speed + " km/h");
    }
}