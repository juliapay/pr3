package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.example1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenToClient2 {
    public static void main(String[] args) {
        int port = 1111;
        // Erstellen eines ServerSockets, der auf Port 1111 lauscht
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Endlosschleife, um kontinuierlich Verbindungen von Clients zu akzeptieren
            while (true) {
                // Akzeptieren einer eingehenden Verbindung (blockiert, bis eine Verbindung hergestellt wird)
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Erstellen und Starten eines neuen ClientHandler-Threads für jede neue Verbindung
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            // Fehlerbehandlung und Ausgabe der Fehlermeldung bei Problemen mit dem Server
            System.out.println("Exception in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
