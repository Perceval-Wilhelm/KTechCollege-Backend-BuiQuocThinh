package vn.edu.likelion.day16;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread đang chạy");

        // Blocked state - cố gắng lấy một khóa
        synchronized(this) {
            try {
                System.out.println("Thread sẽ đợi");
                wait(1000); // Trạng thái Timed Waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Trạng thái Timed Waiting bằng cách sử dụng sleep
        try {
            System.out.println("Thread sẽ ngủ");
            Thread.sleep(2000); // Trạng thái Timed Waiting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Trạng thái Waiting bằng cách sử dụng join
        try {
            System.out.println("Thread đang đợi một thread khác kết thúc");
            Thread anotherThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500); // Trạng thái Timed Waiting của thread khác
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            anotherThread.start();
            anotherThread.join(); // Trạng thái Waiting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread đang kết thúc");
    }
}

public class ThreadLifeCycle {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        System.out.println("Trạng thái của thread: " + thread.getState()); // NEW

        thread.start();
        System.out.println("Trạng thái của thread: " + thread.getState()); // RUNNABLE

        try {
            Thread.sleep(100); // Đợi một chút để thread chuyển sang RUNNING
            System.out.println("Trạng thái của thread: " + thread.getState()); // RUNNING

            synchronized(thread) {
                thread.notify(); // Đánh thức thread ra khỏi trạng thái WAITING hoặc TIMED_WAITING
            }

            Thread.sleep(3500); // Đợi thread kết thúc
            System.out.println("Trạng thái của thread: " + thread.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
