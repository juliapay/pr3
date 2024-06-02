package at.campus02.pr3.PROBE.PruefungChatMitThreadLogFileException;

import java.io.File;

public class ThreadBackground implements Runnable {
    File logFileFromMain;

    public ThreadBackground(File logFileFromMain) {
        this.logFileFromMain = logFileFromMain;
    }


    public void run() {
        // Solange isRunning wahr ist, wird die Schleife ausgeführt.
        while (!Thread.interrupted()) {
            // Erstellt ein neues Date-Objekt, das das aktuelle Datum und die Zeit enthält.

            // Gibt das Datum und die Zeit in der Standardformatierung aus.
            System.out.println(logFileFromMain.length());
                // Lässt den Thread für 5000 Millisekunden (5 Sekunde) schlafen.

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new LogFileException(e.getMessage());
            }

        }
    }
}
