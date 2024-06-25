package Bai4;

public class Main {
    public static void main(String[] args) {
        Truck truck = new Truck("Tatra 810 4x4", 8.075659532105526, 65.50975012444003, 80);
        Car car = new Car("Virtus", 2.355, 14.419665, 120);
        Motor motor = new Motor("Warrior200", 2.1, 4.41, 80);

        truck.model("Tatra 810 4x4");
        truck.fuel_efficiency(8.075659532105526);
        truck.traveled(65.50975012444003);
        truck.max_speed(80);
        truck.fuel_consume(8.075659532105526, 65.50975012444003);
        System.out.println();

        car.model("Virtus");
        car.fuel_efficiency(2.355);
        car.traveled(14.419665);
        car.max_speed(120);
        car.fuel_consume(2.355, 14.419665);
        System.out.println();

        motor.model("Warrior200");
        motor.fuel_efficiency(2.1);
        motor.traveled(4.41);
        motor.max_speed(80);
        motor.fuel_consume(4.41, 80);
    }
}
