package at.campus02.pr3.NETZWERK.ClientToServer1.ChatProgramm;



import java.io.*;
import java.net.Socket;

public class Client40005To40004 {
    public static void main(String[] args) {
        try {
            // Erstelle eine Verbindung zum Server auf bernhardfuchs.at, Port 40056
            Socket socket = new Socket("bernhardfuchs.at", 40004);

            // Reader zum Einlesen der Benutzereingaben aus der Konsole
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            // Reader zum Einlesen von Nachrichten vom Server
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Writer zum Senden von Nachrichten an den Server
            PrintWriter socketWriter = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Verbindung zu bernhardfuchs.at auf Port 40004 hergestellt.");
            System.out.println("Geben Sie Nachrichten ein, um sie zu senden:");

            // Hauptschleife zum Senden und Empfangen von Nachrichten
            while (true) {
                // Prüfe, ob eine Nachricht vom Server empfangen wurde
                if (socketReader.ready()) {
                    String serverResponse = socketReader.readLine();
                    System.out.println("Nachricht von 40004: " + serverResponse);
                }

                // Prüfe, ob der Benutzer eine Nachricht eingegeben hat
                if (userInputReader.ready()) {
                    String userInput = userInputReader.readLine();
                    socketWriter.println(userInput);
                }

                // Kurze Pause, um die CPU-Auslastung zu reduzieren
         //       Thread.sleep(100);
            }

        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
