package at.campus02.pr3.THREADS.Uhrzeit.ue03_02;

import java.util.Date;

/*
Erweitern Sie Ihr „Uhr-Beispiel“, sodass neben der Uhrzeit auch die Anzahl
an CPUs und der noch aus Sicht von Java freie Speicher ausgegeben wird:

▪ Date d = new Date();
▪ System.out.print("[");
▪ System.out.print(d.toString());
▪ System.out.print(", CPUS: ");
▪ System.out.print(Runtime.getRuntime().availableProcessors());
▪ System.out.print(", FreeMem: "); ▪ System.out.print(Runtime.getRuntime().freeMemory());
▪ System.out.print("]");

 Starten Sie zwei „Uhr-Threads“ gleichzeitig

 Entdecken Sie, dass sich die beiden Threads in die Quere kommen?

 Definieren Sie die Ausgabe als „Kritische Sektion“ mit synchronized

 Führen Sie die Anwendung erneut aus und stellen sie fest, dass
 sich die Threads nicht mehr in die Quere kommen.
 */

import java.util.Date;

public class Clock implements Runnable {

    // Eine Variable, um den Laufzustand des Threads zu steuern.
    private boolean isRunning = true;
    // Ein statisches Sperrobjekt zur Synchronisation.
    private static final Object lock = new Object();

    // Die run-Methode, die beim Starten des Threads ausgeführt wird.
    @Override
    public void run() {
        // Solange isRunning wahr ist, wird die Schleife ausgeführt.
        while (isRunning) {
            // Synchronisierter Block, um sicherzustellen, dass die Ausgabe eine kritische Sektion ist.
            synchronized (lock) {
                // Erstellt ein neues Date-Objekt, das das aktuelle Datum und die Zeit enthält.
                Date d = new Date();
                // Ausgabe der Uhrzeit, der Anzahl der CPUs und des freien Speichers.
                System.out.print("[");
                System.out.print(d.toString());
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.println("]");
            }
            try {
                // Lässt den Thread für 1000 Millisekunden (1 Sekunde) schlafen.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Wirft eine RuntimeException, falls der Thread unterbrochen wird.
                throw new RuntimeException(e);
            }
        }
    }

    // Eine Methode, die von außerhalb aufgerufen wird, um den Thread sanft zu stoppen.
    public void requestShutDown() {
        // Gibt eine Nachricht aus, dass ein Shutdown-Antrag erhalten wurde.
        System.out.println("Thread got shutdown Request");
        // Setzt isRunning auf false, was die Schleife in der run-Methode beendet und den Thread stoppt.
        isRunning = false;
    }
}

