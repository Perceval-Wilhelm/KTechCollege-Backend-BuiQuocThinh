package Bai1.Method5;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        Thread a = new Thread(evenThread(array));
        Thread b = new Thread(oddThread(array));
        a.start();
        b.start();

    }

    public static Runnable evenThread(int[] arr){
        return () -> {
            for(int i : arr) {
                try {
                    Thread.sleep(500);
                    if(i % 2 == 0) {
                        System.out.println("Even Number from evenThread: " + i);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static Runnable oddThread(int[] arr){
        return () -> {
            for(int i : arr) {
                try {
                    Thread.sleep(500);
                    if(i % 2 != 0) {
                        System.out.println("Odd Number from oddThread: " + i);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
