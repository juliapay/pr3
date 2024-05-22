package at.campus02.pr3.THREADS.Stoppen;

// Definiert eine Klasse namens PersonStop, die das Runnable-Interface implementiert,
// um in einem eigenen Thread laufen zu können.
public class PersonStop implements Runnable {

    // Private Variable für den Namen der Person.
    private String name;

    // Variable zum Steuern des Laufzustands des Threads.
    private boolean isRunning = true;

    // Konstruktor der Klasse, der den Namen der Person beim Erstellen eines Objekts setzt.
    public PersonStop(String name) {
        this.name = name;
    }

    // Methode, die von außen aufgerufen wird, um den Thread sanft zu stoppen.
    public void requestShutDown() {
        System.out.println("Thread got shutdown Request");
        isRunning = false;  // Setzt isRunning auf false, was den Thread dazu bringt, seine Ausführung zu stoppen.
    }

    // Die run-Methode, die beim Start des Threads ausgeführt wird.
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // Überprüft, ob das Beenden des Threads angefordert wurde.
            if (!isRunning) {
                break;  // Beendet die Schleife und damit den Thread, wenn isRunning auf false gesetzt ist.
            }
            // Gibt den Namen der Person und den Namen des aktuellen Threads aus.
            System.out.println("Person " + name + " und mein Thread heißt: " + Thread.currentThread().getName() + "'");
            try {
                // Der Thread schläft für 1000 Millisekunden.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Wirft eine RuntimeException, falls der Thread unterbrochen wird.
                throw new RuntimeException(e);
            }
        }
        // Gibt eine Nachricht aus, wenn der Thread beendet wird.
        System.out.println(Thread.currentThread().getName() + " is finished.");
    }
}

