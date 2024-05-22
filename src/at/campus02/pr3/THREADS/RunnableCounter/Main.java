package at.campus02.pr3.THREADS.RunnableCounter;

public class Main {
    public static void main(String[] args) {
        Worker w1 = new Worker();


        Thread t1= new Thread(w1);
        Thread t2= new Thread(w1);
        System.out.println("MAIN: Starting up.");
        t1.start();
        t2.start();



        System.out.println("Fertig!");
    }
}
