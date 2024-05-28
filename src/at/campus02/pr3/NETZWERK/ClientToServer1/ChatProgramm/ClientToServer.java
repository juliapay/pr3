package at.campus02.pr3.NETZWERK.ClientToServer1.ChatProgramm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientToServer {
    public static void main(String[] args) {
        try {
            // Erstelle eine Verbindung zum Server auf bernhardfuchs.at, Port 40056
            Socket socket = new Socket("bernhardfuchs.at", 40056);

            // Reader zum Einlesen der Benutzereingaben aus der Konsole
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            // Reader zum Einlesen von Nachrichten vom Server
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Writer zum Senden von Nachrichten an den Server
            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Verbindung zu bernhardfuchs.at von Port 40056 hergestellt.");
            System.out.println("Geben Sie Nachrichten ein, um sie zu senden:");

            // Hauptschleife zum Senden und Empfangen von Nachrichten
            while (true) {
                // Prüfe, ob eine Nachricht vom Server empfangen wurde
                if (socketReader.ready()) {
                    String serverResponse = socketReader.readLine();
                    System.out.println("Nachricht vom Chat: " + serverResponse);
                }

                // Prüfe, ob der Benutzer eine Nachricht eingegeben hat
                if (userInputReader.ready()) {
                    String userInput = userInputReader.readLine();
                    socketWriter.println(userInput);
                }

                // Kurze Pause, um die CPU-Auslastung zu reduzieren
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


