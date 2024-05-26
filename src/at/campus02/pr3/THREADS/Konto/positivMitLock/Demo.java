package at.campus02.pr3.THREADS.Konto.positivMitLock;

public class Demo {

    public static void main(String[] args) {
        // Erstellt zwei Konto-Instanzen mit Anfangsguthaben.
        Konto k1 = new Konto(100); // Konto k1 mit einem Startguthaben von 100.
        Konto k2 = new Konto(200); // Konto k2 mit einem Startguthaben von 200.

        // Erstellt zwei Worker-Objekte, die Runnable sind.
        // Jeder Worker wird mit unterschiedlichen Konten initialisiert, um die Synchronisation zu demonstrieren.
        Runnable w1 = new Worker('A', k1, k2); // Worker A, der k1 und k2 manipuliert.
        Runnable w2 = new Worker('B', k2, k1); // Worker B, der k2 und k1 manipuliert.

        // Erstellt Threads für die Worker-Objekte.
        Thread t1 = new Thread(w1); // Thread für Worker A.
        Thread t2 = new Thread(w2); // Thread für Worker B.

        // Startet die Threads.
        t1.start();
        t2.start();

        // Wartet auf das Ende beider Threads.
        try {
            t1.join(); // Wartet, bis Thread t1 seine Arbeit beendet hat.
            t2.join(); // Wartet, bis Thread t2 seine Arbeit beendet hat.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Druckt den Stack Trace im Fehlerfall.
        }

        // Gibt die finalen Werte der Konten aus.
        System.out.println(k1.getWert()); // Ausgabe des Endguthabens von Konto k1.
        System.out.println(k2.getWert()); // Ausgabe des Endguthabens von Konto k2.
    }
}
