package at.campus02.pr3.THREADS.examplePerson;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // Erstellt zwei Runnable-Objekte, p1 und p2, jeweils mit einer Instanz der Person-Klasse und unterschiedlichen Namen.
        Runnable p1 = new Person("Andreas");
        Runnable p2 = new Person("Uschi");

        // Erstellt zwei Threads, t1 und t2, und weist jedem einen der Runnable-Objekte (Personen) zu.
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        // Startet die Threads. Wenn gestartet, führen sie ihre run-Methode aus der Person-Klasse aus.
        t1.start();
        t2.start();

        try {
            // Druckt eine Nachricht, die anzeigt, dass das Hauptprogramm auf die Beendigung von t1 wartet.
            System.out.println("MAIN: Warte auf Thread 1...");
            t1.join(); // Wartet, bis t1 vollständig ausgeführt ist.
            // Druckt eine Nachricht, die anzeigt, dass das Hauptprogramm auf die Beendigung von t2 wartet.
            System.out.println("MAIN: Warte auf Thread 2...");
            t2.join(); // Wartet, bis t2 vollständig ausgeführt ist.
        } catch (InterruptedException e) {
            // Druckt die StackTrace-Informationen, falls während des Wartens eine Unterbrechung auftritt.
            e.printStackTrace();
        }

        System.out.println("Main: Ende");
    }
}
