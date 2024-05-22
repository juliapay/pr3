package at.campus02.pr3.THREADS.Stoppen;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Erstellt zwei Objekte der Klasse PersonStop mit verschiedenen Namen ("1" und "2").
        PersonStop p1 = new PersonStop("1");
        PersonStop p2 = new PersonStop("2");

        // Erstellt zwei Threads, t1 und t2, und weist jedem einen der PersonStop-Objekte zu.
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        // Startet die Threads. Wenn gestartet, führen sie ihre run-Methode aus der PersonStop-Klasse aus.
        t1.start();
        t2.start();

        // Gibt den aktuellen Status der Threads t1 und t2 aus. Dies erfolgt unmittelbar nach dem Starten der Threads.
        System.out.println("State t1: " + t1.getState());
        System.out.println("State t2: " + t2.getState());

        // Der Hauptthread pausiert für 1200 Millisekunden (1,2 Sekunden).
        Thread.sleep(1200);

        // Fordert das höfliche Stoppen des Threads t1 an, indem die requestShutDown-Methode aufgerufen wird.
        p1.requestShutDown();

        // Der Hauptthread pausiert erneut für 1200 Millisekunden.
        Thread.sleep(1200);

        // Fordert das höfliche Stoppen des Threads t2 an.
        p2.requestShutDown();

        // Gibt eine Nachricht aus, die das Ende des Hauptprogramms anzeigt.
        System.out.println("Main: Ende");
    }
}

