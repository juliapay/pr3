package at.campus02.pr3.THREADS.kritischeSektionen;

// Definiert die Klasse PersonKritisch, die das Runnable-Interface implementiert, um in Threads verwendet zu werden.
public class PersonKritisch implements Runnable {

    private String name; // Variable, die den Namen der Person speichert.

    private static Object lock = new Object(); // Statisches Lock-Objekt zur Synchronisation von Threads.

    private boolean isRunning = true; // Variable, die steuert, ob der Thread weiterlaufen soll.

    // Konstruktor der Klasse, initialisiert die Instanz mit einem spezifischen Namen.
    public PersonKritisch(String name) {
        this.name = name;
    }

    // Methode, die von außen aufgerufen wird, um den Thread sanft zu stoppen.
    public void requestShutDown() {
        System.out.println("Thread got shutdown Request"); // Gibt eine Nachricht aus, wenn der Shutdown angefordert wird.
        isRunning = false; // Ändert isRunning auf false, um die Schleife in der run-Methode zu beenden.
    }

    // Die run-Methode, die definiert, was der Thread tun soll.
    @Override
    public void run() {
        // Synchronisierter Block, der sicherstellt, dass dieser Codeabschnitt zu einem Zeitpunkt nur von einem Thread ausgeführt wird.
        synchronized (lock) {

            // Schleife, die maximal 10 Mal durchlaufen wird, solange isRunning true bleibt.
            for (int i = 0; i < 10; i++) {

                // Überprüft, ob ein Shutdown angefordert wurde. Wenn ja, wird die Schleife abgebrochen.
                if (!isRunning) {
                    break;
                }
                // Gibt den Namen der Person und den Namen des ausführenden Threads aus.
                System.out.println("Person " + name + " und mein Thread heißt: " + Thread.currentThread().getName() + "'");

                // Der Thread wird für eine Sekunde (1000 Millisekunden) pausiert.
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Wirft eine RuntimeException, wenn das Thread-Schlafen unterbrochen wird.
                    throw new RuntimeException(e);
                }
            }
        }
        // Gibt eine Nachricht aus, wenn der Thread vollständig ausgeführt wurde.
        System.out.println(Thread.currentThread().getName() + " is finished.");
    }
}

