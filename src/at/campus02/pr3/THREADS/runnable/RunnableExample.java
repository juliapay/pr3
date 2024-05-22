package at.campus02.pr3.THREADS.runnable;

// Deklariert eine öffentliche Klasse RunnableExample, die das Runnable-Interface implementiert.
public class RunnableExample implements Runnable {

    // Implementiert die run-Methode, die erforderlich ist, da RunnableExample das Runnable-Interface implementiert.
    @Override
    public void run() {
        // Holt den aktuellen Thread, in dem diese Methode läuft, und weist ihn einer lokalen Variable zu.
        Thread aktuellerFaden = Thread.currentThread();
        // Gibt den Namen des aktuellen Threads aus.
        System.out.println("I am inside: " + aktuellerFaden.getName());
    }

    // Die Hauptmethode des Programms, dient als Einstiegspunkt.
    public static void main(String[] args) {
        // Gibt eine einführende Nachricht aus.
        System.out.println("Hello from Demo03: RunnableExample");

        System.out.println("Creating runnable...");
        // Erstellt ein Objekt der Klasse RunnableExample.
        RunnableExample r1 = new RunnableExample();

        System.out.println("Creating Thread...");
        // Erstellt einen Thread t1 und übergibt das Runnable-Objekt r1 an den Konstruktor.
        Thread t1 = new Thread(r1);
        // Gibt den Namen des gerade erstellten Threads aus.
        System.out.println("done. Name of new Thread: "+t1.getName());

        System.out.println("Start Thread...");
        // Startet den Thread t1, wodurch die run-Methode von r1 aufgerufen wird.
        t1.start(); // Wichtig: t1.run() würde run() im Hauptthread ausführen und nicht im neuen Thread t1.
    }
}
