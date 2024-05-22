package at.campus02.pr3.THREADS.Threads2Synchronized;

import java.util.Date;

public class Worker implements Runnable {

    private final int sleepInterval = 2000; //1000 msec = 1 SEK
    private boolean isRunning = true;
    //muss static sein, damit nicht jeder thread ein eigenes lock bekommt
    private static Object lock=new Object();

    public void requestShutDown() {
        isRunning = false;
    }

    @Override
    public void run() {

        while (isRunning) {
            // im while,da sonst ein thread seinen ganzen zyklus durchläuft
            synchronized (lock) {
                Date current_date = new Date();
                System.out.println(Thread.currentThread().getName());
                System.out.print("[");
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.print("]");
                try {
                    Thread.sleep(sleepInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


