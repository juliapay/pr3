package at.campus02.pr3.PROBE.PAYER;

import java.io.*;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ThreadBackground t = new ThreadBackground();
        Thread t1 = new Thread(t);
        t1.start();

        try {
            // Erstelle eine Verbindung zum Server auf bernhardfuchs.at, Port 40056
            Socket socket = new Socket("bernhardfuchs.at", 40056);

            // Reader zum Einlesen der Benutzereingaben aus der Konsole
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            // Reader zum Einlesen von Nachrichten vom Server
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Writer zum Senden von Nachrichten an den Server
            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);
            File file = new File(" jp_Logfile.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("Verbindung zu bernhardfuchs.at von Port 40056 hergestellt.");
            System.out.println("Geben Sie Nachrichten ein, um sie zu senden:");
            String userInput = userInputReader.readLine();

            // Hauptschleife zum Senden und Empfangen von Nachrichten
            while (!(userInput.equalsIgnoreCase("ende"))) {

                // Prüfe, ob eine Nachricht vom Server empfangen wurde
                if (socketReader.ready()) {
                    String serverResponse = socketReader.readLine();
                    System.out.println("<---DATEN VOM CHAT " + serverResponse);
                    //schreiben in datei
                    bufferedWriter.write(socketReader.readLine());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                }

                if (userInput.equalsIgnoreCase("ende")) {
                    t.requestShutDown();
                    bufferedWriter.close();
                    break;
                }
                // Prüfe, ob der Benutzer eine Nachricht eingegeben hat
                if (userInputReader.ready()) {
                    socketWriter.println("--->DATEN GESENDET VOM USER" + userInput);

                }

                //  Kurze Pause, um die CPU-Auslastung zu reduzieren
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

