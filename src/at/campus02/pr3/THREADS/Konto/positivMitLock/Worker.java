package at.campus02.pr3.THREADS.Konto.positivMitLock;

public class Worker implements Runnable {

    private char sign; // Zeichen zur Identifikation des Workers in der Ausgabe.

    private final int count = 10; // Anzahl der Wiederholungen in der Schleife.
    private final int sleepIntervall = 10; // Schlafintervall zwischen den Aktionen in Millisekunden.

    private Konto k1; // Erstes Konto, mit dem der Worker arbeitet.
    private Konto k2; // Zweites Konto, mit dem der Worker arbeitet.

    private static Object lock = new Object(); // Statisches Sperrobjekt zur Synchronisation.

    // Konstruktor, der den Worker initialisiert mit einem Zeichen für die Ausgabe und zwei Konto-Objekten.
    public Worker(char sign, Konto k1, Konto k2) {
        this.sign = sign;
        this.k1 = k1;
        this.k2 = k2;
    }

    // Die run-Methode, die die eigentliche Aufgabe des Workers definiert.
    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            synchronized (lock) { // Beginn eines synchronisierten Blocks, der den Zugriff auf die Konten serialisiert.
                double wert1 = k1.getWert(); // Liest den aktuellen Wert des ersten Kontos.
                System.out.println(sign + ": Wert von k1 ermittelt");

                double wert2 = k2.getWert(); // Liest den aktuellen Wert des zweiten Kontos.
                System.out.println(sign + ": Wert von k2 ermittelt");

                k1.setWert(wert1 - 10); // Zieht 10 Einheiten vom ersten Konto ab.
                System.out.println(sign + ": 10 von k1");

                k2.setWert(wert2 + 10); // Fügt 10 Einheiten zum zweiten Konto hinzu.
                System.out.println(sign + ": 10 auf k2");
            }

            try {
                Thread.sleep(sleepIntervall); // Der Thread schläft für das festgelegte Intervall.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
