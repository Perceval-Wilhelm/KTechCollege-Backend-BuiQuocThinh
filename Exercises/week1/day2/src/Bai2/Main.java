package Bai2;

public class Main {
    public static void main(String[] args){
        /*
        Bài 2
         */
        Employee employee = new Employee("employee", 40000);
        employee.work("employee");
        employee.getSalary("Employee", 40000);

        HRManager hr = new HRManager("employees", 70000);
        hr.work("employees");
        hr.getSalary("Manager", 70000);
        hr.addEmployee();
    }
}