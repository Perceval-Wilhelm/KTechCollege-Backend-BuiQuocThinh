package Bai1.Method3;

public class Odd3 extends Thread{
    private int num;

    public Odd3(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 1; i <= num; i++) {
            try {
                Thread.sleep(500);
                if ((i&1) != 0) System.out.println("Odd Number from oddThread: " + i);
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
