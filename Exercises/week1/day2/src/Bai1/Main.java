package Bai1;

public class Main {
    public static void main(String[] args){
        /*
        Bài 1
         */
        Vehicle vehicle = new Vehicle(30);
        vehicle.SpeedUp(30);

        Car car = new Car(40);
        car.SpeedUp(40);

        Bicycle bicycle = new Bicycle(20);
        bicycle.SpeedUp(20);
    }
}