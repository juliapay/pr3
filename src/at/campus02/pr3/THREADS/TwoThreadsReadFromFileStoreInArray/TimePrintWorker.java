package at.campus02.pr3.THREADS.TwoThreadsReadFromFileStoreInArray;

import java.util.Date;

public class TimePrintWorker extends Worker implements Runnable {
    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    protected void work() {
        printStarted();
        while (shouldRun) {
            if (shouldRun = false) {
                break;
            }
            Date d = new Date();
            System.out.println(d.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        printStopped();
    }

    @Override
    public void run() {
        work();

    }


}
