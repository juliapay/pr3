package at.campus02.pr3.THREADS.RunnableCounterMitNotifyWait;

public class Main {
    public static void main(String[] args) {
        Worker w = new Worker();
        Thread t1= new Thread(w);
        Thread t2= new Thread(w);
        System.out.println("Uebung mit wait und notify");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ende Gelände");
    }
    }

