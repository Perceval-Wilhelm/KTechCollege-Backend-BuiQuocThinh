package Bai3;

public class Main {
    public static void main(String[] args){
        /*
        Bài 3
         */
        Manager manager = new Manager("Avril Aroldo", "", 12000, "Manager", "Excellent", 100000);
        Developer developer = new Developer("Iver Dipali", "", 7200, "Developer", "Good", 80000);
        Programmer programmer = new Programmer("Yaron Gabriel", "", 9120, "Programmer", "Excellent", 90000);

        manager.bonus("Manger", 12000);
        developer.bonus("Developer", 72000);
        programmer.bonus("Programmer", 9120);
        manager.report("Avril Aroldo", "Manager", "Excellent");
        developer.report("Iver Dipali", "Developer", "Good");
        programmer.report("Yaron Gabriel", "Programmer", "Excellent");
        manager.manage("Manager", "Avril Aroldo");
        developer.manage("Developer", "Iver Dipali");
        programmer.manage("Programmer", "Yaron Gabriel");
        manager.total_salary(100000, 12000);
        developer.total_salary(80000, 72000);
        programmer.total_salary(90000, 9120);
    }
}