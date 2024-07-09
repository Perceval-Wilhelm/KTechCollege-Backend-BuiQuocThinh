package vn.edu.likelion.day16;

public class Banking implements Runnable {

    private Account account;

    public Banking(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            this.account.withdraw(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
