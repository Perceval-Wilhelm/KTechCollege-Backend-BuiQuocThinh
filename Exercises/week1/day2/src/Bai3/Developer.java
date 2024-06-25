package Bai3;

public class Developer extends Employee {
    public Developer(String name, String address, float bonus, String role, String eval, float salary) {
        super(name, address, bonus, role, eval, salary);
    }

    @Override
    public void manage(String role, String name) {
        System.out.println(role + " " + name + " is writing code in Java");
    }
}