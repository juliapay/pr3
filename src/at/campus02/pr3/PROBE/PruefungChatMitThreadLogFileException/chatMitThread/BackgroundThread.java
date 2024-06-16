package at.campus02.pr3.PROBE.PruefungChatMitThreadLogFileException.chatMitThread;

import java.io.File;

public class BackgroundThread implements Runnable{
    File logFile;
    // Konstruktor, der die Log-Datei als Parameter erhält
    public BackgroundThread(File logfile) {
        this.logFile=logfile;
    }

    @Override
    public void run() {
        // Endlosschleife, die läuft, bis der Thread unterbrochen wird
        while (!Thread.interrupted()){
            // Ausgabe der Länge der Log-Datei in Bytes
            System.out.println(logFile.length());


            try {
                // Der Thread schläft für 5 Sekunden
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Wenn der Thread unterbrochen wird, wird eine benutzerdefinierte Ausnahme geworfen
                throw new LogFileException(e.getMessage());
            }

        }
    }
}
