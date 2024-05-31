package at.campus02.pr3.THREADS;

public class ThreadCheatSheet {
    public static void main(String[] args) {
        //----CURRENT THREAD-----
        // Holt den aktuellen Thread, in dem dieser Code läuft, und speichert ihn in einer Variablen.
        Thread aktuellerFaden = Thread.currentThread();
        // Gibt den Namen des aktuellen Threads aus. Standardmäßig ist dies "main".
        System.out.println("I am inside: " + aktuellerFaden.getName());

    }
}
