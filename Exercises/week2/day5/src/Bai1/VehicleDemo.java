package Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleDemo {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();

        int count = 0;
        for (int i=0; i<10; i++) {
            Random randCar = new Random();
            Random randBike = new Random();
            Car car =  new Car(randCar.nextInt(1000), randCar.nextInt(2,4));
            Bike bike = new Bike(randBike.nextInt(1000), randBike.nextBoolean());

            vehicles.add(car);
            vehicles.add(bike);

            vehicles.get(count++).move();
            vehicles.get(count++).move();
            System.out.println();
        }

        System.out.println(Vehicle.vehicleCount);
    }
}
