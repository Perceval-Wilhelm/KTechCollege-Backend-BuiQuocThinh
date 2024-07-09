package Bai1;

public class Odd2 implements Runnable {
    private int num;

    public Odd2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 1; i <= num; i++) {
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
