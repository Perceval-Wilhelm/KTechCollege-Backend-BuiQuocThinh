package Bai2;

public class HRManager extends Employee{
    public HRManager(String role, int salary) {
        super(role, salary);
    }

    @Override
    public void work(String role) {
        System.out.println("Managing " + role);
    }

    @Override
    public void getSalary(String role, int salary) {
        super.getSalary(role, salary);
    }

    public void addEmployee(){
        System.out.println("Adding new employee!");
    }
}