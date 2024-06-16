package at.campus02.pr3.NETZWERK.ClientToServer;

import java.io.*;
import java.net.Socket;

public class SocketVerbindungClientToServer {
    public static void main(String[] args) throws IOException {

        // Erstellen eines Sockets zum Verbinden mit dem Server "bernhardfuchs.at" an Port 40005
        Socket socket = new Socket("bernhardfuchs.at", 40005);

        // Erstellen eines BufferedReader zum Lesen von Daten vom Server
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Reading from Server");

        // Erstellen eines BufferedWriter zum Senden von Daten an den Server
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String command;
        // Lesen von Befehlen vom Server in einer Schleife
        while ((command = bufferedReader.readLine()) != null) {
            // Wenn der empfangene Befehl "ping" ist
            if ("ping".equals(command)) {
                // Senden der Antwort "pong" an den Server
                bufferedWriter.write("pong");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            // Wenn der empfangene Befehl "stop" ist
            else if ("stop".equals(command)) {
                // Senden der Antwort "BYE" an den Server
                bufferedWriter.write("BYE");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break; // Beenden der Schleife
            }
            // Wenn der empfangene Befehl unbekannt ist
            else {
                // Senden der Antwort "unknown command" an den Server
                bufferedWriter.write("unknown command");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
        // Schließen der Streams und des Sockets nach Verlassen der Schleife
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
    }
}
