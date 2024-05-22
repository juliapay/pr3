package at.campus02.pr3.THREADS.ThreadTwice;

//Methode
public class ThreadStartTwice extends Thread {
    public void run() {
        System.out.println("Hello world!");

        Thread aktuellerFaden = Thread.currentThread();
        System.out.println("I am inside: " + Thread.currentThread().getName());

    }

    // Hauptmethode des Programms. 'throws InterruptedException' wird benötigt, weil beim Arbeiten mit Threads möglicherweise Unterbrechungen auftreten können.
    public static void main(String[] args) throws InterruptedException {
        // Erstellt ein Objekt der Klasse ThreadStartTwice, benannt als t1.
        ThreadStartTwice t1 = new ThreadStartTwice();
        // Startet den Thread t1. Einmal gestartet, beginnt t1 mit der Ausführung
        // der in der Klasse ThreadStartTwice definierten run-Methode.
        t1.start();

        // Erstellt ein weiteres Objekt der Klasse ThreadStartTwice, benannt als t2.
        ThreadStartTwice t2 = new ThreadStartTwice();
        // Startet den Thread t2. Wie bei t1 wird die run-Methode ausgeführt.
        t2.start();

        // Dieser Teil ist auskommentiert. Er demonstriert, dass ein Versuch, t2 ein zweites Mal zu starten, zu einer Exception führen würde.
        // Ein Thread kann nicht mehr als einmal gestartet werden.
        // t2.start();
    }

}

