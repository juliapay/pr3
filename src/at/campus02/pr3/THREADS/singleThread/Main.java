package at.campus02.pr3.THREADS.singleThread;


// Definiert eine öffentliche Klasse namens Main.
public class Main {
    // Die Hauptmethode, die als Einstiegspunkt für das Programm dient.
    public static void main(String[] args) {

        System.out.println("Hello world!");

        // Holt den aktuellen Thread, in dem dieser Code läuft, und speichert ihn in einer Variablen.
        Thread aktuellerFaden = Thread.currentThread();
        // Gibt den Namen des aktuellen Threads aus. Standardmäßig ist dies "main".
        System.out.println("I am inside: " + aktuellerFaden.getName());
    }
}
