package at.campus02.pr3.THREADS.RunnableCounter;

public class Worker implements Runnable {

    int counter;
    private static Object lock = new Object();

    @Override
    public void run() {

        while (counter < 20) {
            synchronized (lock) {

                counter++;

                System.out.println(Thread.currentThread().getName()+" counts " + (counter));

            }
            try {
                //sleep muss außerhalb des locks sein
                Thread.sleep(1000);
                // Lässt den Thread für 1000 Millisekunden (1 Sekunde) schlafen.

            } catch (InterruptedException e) {
                // Wirft eine RuntimeException, falls der Thread unterbrochen wird.
                Thread.currentThread().interrupt();
            }
        }

    }
}
