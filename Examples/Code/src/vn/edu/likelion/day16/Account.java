package vn.edu.likelion.day16;

public class Account {
    private double amount;

    public Account(double amount) {
        this.amount = amount;
    }

    public synchronized void withdraw(double amount) throws InterruptedException {
        if (this.amount >= amount) {
            Thread.sleep(1000);
            this.amount -= amount;
            System.out.println(this.amount);
        } else System.out.println("Hết tiền");
    }
}
