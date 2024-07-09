package Bai1;

public class Even extends Thread {
    private int x;

    public Even(int x) {
        this.x = x;
    }

    @Override
    public void run() {
        for (int i = 1; i <= x; i++) {
            try {
                Thread.sleep(500);
                if (i % 2 != 0) {
                    System.out.println("Odd Number from oddThread: " + i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
