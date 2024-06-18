package at.campus02.pr3.THREADS.RunnableCounterSynchronized;

public class Main {
    public static void main(String[] args) {
        Worker w1 = new Worker();


        Thread t1= new Thread(w1);
        Thread t2= new Thread(w1);
        System.out.println("MAIN: Starting up.");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Fertig!");
    }
}
