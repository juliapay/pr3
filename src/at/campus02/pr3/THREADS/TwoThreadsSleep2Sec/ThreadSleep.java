package at.campus02.pr3.THREADS.TwoThreadsSleep2Sec;

public class ThreadSleep extends Thread {

    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public void print() {
        System.out.println("test");
    }

    public static void main(String args[]) {
        /*
        We can call run() method if we want but then it would behave just like
        a normal method and we would not be able to take the advantage of
        multithreading.
        When the run method gets called though start() method
        then a new separate thread is being allocated to the execution of
        run method, so if more than one thread calls start() method that
        means their run method is being executed by separate threads (these
        threads run simultaneously).
         */

        ThreadSleep t1 = new ThreadSleep();
        ThreadSleep t2 = new ThreadSleep();

        t1.start();
        t2.start();
    }
}
