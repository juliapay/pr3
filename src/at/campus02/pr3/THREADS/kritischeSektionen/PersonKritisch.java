package at.campus02.pr3.THREADS.kritischeSektionen;


public class PersonKritisch implements Runnable {
    private String name;
    private static Object lock = new Object();
    private boolean isRunning = true;

    public PersonKritisch(String name) {
        this.name = name;
    }

    public void requestShutDown() {
        System.out.println("Thread got shutdown Request");
        isRunning = false;
    }
    @Override
    public void run() {
        // Während dieser Synchronized-Block ausgeführt wird, darf
        // kein anderer, der sich auf das selbe "Sperr-Objekt bezieht",
        // ausgeführt werden.

        synchronized (lock) {

            for (int i = 0; i < 10; i++) {
                if (!isRunning) {
                    break;
                }
                System.out.println("Person " + name + " und mein Thread heißt: " + Thread.currentThread().getName() + "'");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                   e.printStackTrace();
                }
            }
        }
        // Gibt eine Nachricht aus, wenn der Thread vollständig ausgeführt wurde.
        System.out.println(Thread.currentThread().getName() + " is finished.");
    }
}

