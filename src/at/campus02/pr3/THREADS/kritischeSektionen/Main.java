package at.campus02.pr3.THREADS.kritischeSektionen;


public class Main {

    public static void main(String[] args)  {

        System.out.println("Mein example kritische Sektionen starting:");
        PersonKritisch p1 = new PersonKritisch("Pablo");
        PersonKritisch p2 = new PersonKritisch("Mia");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();

        System.out.println("State t1: " + t1.getState());
        System.out.println("State t2: " + t2.getState());

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Main: Ende");
    }
}
