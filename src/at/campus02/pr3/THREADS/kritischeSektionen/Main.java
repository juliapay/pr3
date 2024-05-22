package at.campus02.pr3.THREADS.kritischeSektionen;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Mein example kritische Sektionen starting:");
        // Erstellt zwei Instanzen der Klasse PersonKritisch, benannt "1" und "2".
        PersonKritisch p1 = new PersonKritisch("1");
        PersonKritisch p2 = new PersonKritisch("2");

        // Erstellt zwei Threads, t1 und t2, und weist ihnen die oben erstellten PersonKritisch-Instanzen zu.
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        // Startet die beiden Threads, wodurch ihre run-Methode ausgeführt wird.
        t1.start();
        t2.start();

        // Gibt den aktuellen Zustand der beiden Threads aus. Dies zeigt, in welchem Zustand sich die Threads befinden.
        System.out.println("State t1: " + t1.getState());
        System.out.println("State t2: " + t2.getState());

        // Der Hauptthread wartet 500 Millisekunden, bevor weitere Aktionen durchgeführt werden.
        Thread.sleep(500);

        // Auskommentierter Code für ein höfliches Stoppen der Threads.
        // p1.requestShutDown();
        // Thread.sleep(1200);
        // p2.requestShutDown();

        // Gibt eine Nachricht aus, die das Erreichen des Endes des Hauptprogramms signalisiert.
        System.out.println("Main: Ende");
    }
}
