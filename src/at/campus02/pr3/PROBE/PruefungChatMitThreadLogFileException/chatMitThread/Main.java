package at.campus02.pr3.PROBE.PruefungChatMitThreadLogFileException.chatMitThread;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Verbindung zum Server auf localhost, Port 2200 herstellen
        Socket socket = new Socket("localhost", 2200);

        // Leser für Benutzereingaben von der Konsole
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

        // Leser für Daten vom Server
        BufferedReader chatReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Writer für Daten an den Server
        PrintWriter chatOutputWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

        // Log-Datei erstellen und FileWriter initialisieren
        File logFile = new File("logfile_jp.txt");
        FileWriter logFileWriter = new FileWriter(logFile);

        // Hintergrund-Thread zum Überwachen der Log-Datei starten
        Thread thread = new Thread(new BackgroundThread(logFile));
        thread.start();

        // Hauptschleife für die Chat-Kommunikation
        while (true) {
            String userInput = "";
            // Überprüfen, ob Benutzereingaben bereitstehen
            while (userInputReader.ready()) {
                // Benutzereingabe lesen
                userInput = userInputReader.readLine();
                // Senden der Benutzereingabe an den Server und Ausgabe auf der Konsole
                chatOutputWriter.println("---> Daten gesendet vom User: " + userInput);
                System.out.println("---> Daten gesendet vom User: " + userInput);
                chatOutputWriter.flush();
                // Schreiben der Benutzereingabe in die Log-Datei
                logFileWriter.write("---> Daten gesendet vom User: " + userInput + "\n");
                logFileWriter.flush();
            }
            // Wenn der Benutzer "ende" eingibt, wird die Schleife beendet
            if (userInput.equalsIgnoreCase("ende")) {
                System.out.println("User requested shutdown");
                // Hintergrund-Thread unterbrechen
                thread.interrupt();
                // Schließen des LogFileWriters
                logFileWriter.close();
                // Beenden der Schleife
                break;
            }
            // Überprüfen, ob Daten vom Server bereitstehen
            if (chatReader.ready()) {
                // Lesen der Serverantwort
                String serverResponse = chatReader.readLine();
                // Ausgabe der Serverantwort auf der Konsole
                System.out.println("<---Daten gesendet vom Chat: " + serverResponse);
                // Schreiben der Serverantwort in die Log-Datei
                logFileWriter.write("<---Daten gesendet vom Chat: " + serverResponse + "\n");
                logFileWriter.flush();
            }

            // Den Thread für 1 Sekunde schlafen lassen
            Thread.sleep(1000);
        }
    }
}
