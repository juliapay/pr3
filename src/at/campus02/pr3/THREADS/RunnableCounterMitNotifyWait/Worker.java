package at.campus02.pr3.THREADS.RunnableCounterMitNotifyWait;

public class Worker implements Runnable {

    int counter;
    private static Object lock = new Object();

    @Override
    public void run() {


        while (true) {
            synchronized (lock) {
                lock.notify();
                if (counter > 20) {
                    break;
                }
                counter++;
                System.out.println("Thread " + Thread.currentThread().getName() + " counts " + counter);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        synchronized (lock){
            lock.notifyAll();
        }

    }
}
