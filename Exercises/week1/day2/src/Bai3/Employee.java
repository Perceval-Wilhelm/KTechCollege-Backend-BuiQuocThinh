package Bai3;

public class Employee {
    String name;
    String address;
    float bonus;
    String role;
    String eval;
    float salary;

    public Employee(String name, String address, float bonus, String role, String eval, float salary) {
        this.name = name;
        this.address = address;
        this.bonus = bonus;
        this.role = role;
        this.eval = eval;
        this.salary = salary;
    }

    public void bonus(String role, float bonus) {
        System.out.println(role + "'s Bonus: $" + bonus);
    }

    public void report(String name, String role, String eval) {
        System.out.println("Performance report for " + role + " " + name + ": " + eval);
    }

    public void manage(String role, String name) {
        System.out.println(role + " " + name + " is working");
    }

    public void total_salary(float salary, float bonus) {
        System.out.println("Total salary: $" + (salary + bonus));
    }
}