package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ListenToClient {

    public static void main(String[] args) {
        int port = 1111;
        // Erstellen eines ServerSockets, der auf Port 1111 lauscht
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Endlosschleife, um kontinuierlich Verbindungen von Clients zu akzeptieren
            while (true) {
                // Akzeptieren einer eingehenden Verbindung (blockiert, bis eine Verbindung hergestellt wird)
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    // BufferedReader zum Lesen von Daten vom Client
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    // PrintWriter zum Senden von Daten an den Client
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    // Zufällige Anzahl von Runden zwischen 1 und 10
                    int rounds = new Random().nextInt(10) + 1;
                    int count = 0;

                    String inputLine;
                    // Schleife, die Eingaben vom Client liest
                    while ((inputLine = in.readLine()) != null) {
                        // Wenn der Client "ping" sendet
                        if (inputLine.equalsIgnoreCase("ping")) {
                            // Solange die Anzahl der Runden nicht erreicht ist, "pong" zurücksenden
                            if (count < rounds) {
                                out.println("pong");
                                count++;
                            } else {
                                // Wenn die Anzahl der Runden erreicht ist, "ende" senden und die Schleife beenden
                                out.println("ende");
                                break;
                            }
                        }
                        // Wenn der Client "stop" sendet
                        else if (inputLine.equalsIgnoreCase("stop")) {
                            System.out.println("Server stopping...");
                            out.println("Server stopped");
                            System.exit(0); // Server beenden
                        }
                        // Bei unbekannten Befehlen eine entsprechende Nachricht senden
                        else {
                            out.println("Unknown command");
                        }
                    }

                    // Nachricht ausgeben, wenn der Client die Verbindung trennt
                    System.out.println("Client disconnected");
                } catch (IOException e) {
                    // Fehlerbehandlung und Ausgabe der Fehlermeldung bei Problemen mit der Client-Verbindung
                    System.out.println("Exception in client connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            // Fehlerbehandlung und Ausgabe der Fehlermeldung bei Problemen mit dem Server
            System.out.println("Exception in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}