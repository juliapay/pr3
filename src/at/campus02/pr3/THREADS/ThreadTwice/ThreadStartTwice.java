package at.campus02.pr3.THREADS.ThreadTwice;

//Methode
public class ThreadStartTwice extends Thread {
    public void run() {


        Thread aktuellerFaden = Thread.currentThread();
        System.out.println("I am inside: " + Thread.currentThread().getName());

    }

    // Hauptmethode des Programms. 'throws InterruptedException' wird benötigt, weil beim Arbeiten mit Threads möglicherweise Unterbrechungen auftreten können.
    public static void main(String[] args) throws InterruptedException {

        ThreadStartTwice t1 = new ThreadStartTwice();

        t1.start();

        ThreadStartTwice t2 = new ThreadStartTwice();

        t2.start();


    }

}

