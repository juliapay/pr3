package at.campus02.pr3.THREADS.SingleThreadSleeps1Sec;

public class ThreadMethods implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Prio of Thread is " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        ThreadMethods tm = new ThreadMethods();
        Thread thread = new Thread(tm);
        thread.start();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Running");
    }
}
