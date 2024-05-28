package at.campus02.pr3.PROBE.PAYER;

import java.io.File;

public class ThreadBackground implements Runnable{
    protected File file=new File(" jp_Logfile.txt");

    private boolean isRunning = true;

        public void run() {
            // Solange isRunning wahr ist, wird die Schleife ausgeführt.
            while (isRunning) {
                // Erstellt ein neues Date-Objekt, das das aktuelle Datum und die Zeit enthält.

                // Gibt das Datum und die Zeit in der Standardformatierung aus.
                System.out.println(file.length());
                try {
                    // Lässt den Thread für 5000 Millisekunden (5 Sekunde) schlafen.
                    Thread.sleep(5000);
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
