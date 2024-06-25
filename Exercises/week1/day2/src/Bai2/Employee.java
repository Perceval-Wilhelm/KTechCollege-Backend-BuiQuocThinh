package Bai2;

public class Employee {
    String role;
    int salary;

    public Employee(String role, int salary) {
        this.role = role;
        this.salary = salary;
    }

    public void work(String role) {
        System.out.println("Working as an " + role + "!");
    }

    public void getSalary(String role, int salary){
        System.out.println(role + " salary: " + salary);
        System.out.println();
    }
}