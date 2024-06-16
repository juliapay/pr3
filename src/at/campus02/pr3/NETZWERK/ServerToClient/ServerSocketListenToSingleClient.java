package at.campus02.pr3.NETZWERK.ServerToClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ServerSocketListenToSingleClient {
    // start via CommandLine (cmd): telnet localhost 9090
    public static void main(String[] args) throws IOException {
        System.out.println("Warte auf eingehende Verbindungen - Verbinde mit telnet localhost 9090");
        // We are working on localhost !!! = Hostname
        // We have configured Port 9090 for our ServerSocket Port
        // Test the Server Implementation with Putty Application or Telnet Command (see Tutorial within Moodle)

        // Erstellen eines ServerSockets, der auf Port 9090 lauscht
        ServerSocket serverSocket = new ServerSocket(9090);
        // Lesen und Verarbeiten von Befehlen, die vom Client gesendet werden
        // Endlosschleife, um kontinuierlich Verbindungen zu akzeptieren
        while (true) {
            // Akzeptieren einer eingehenden Verbindung (blockiert, bis eine Verbindung hergestellt wird)
            Socket socket = serverSocket.accept();

            // BufferedWriter zum Senden von Daten an den Client
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Senden einer Begrüßungsnachricht an den Client
            bufferedWriter.write("HELLO");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // BufferedReader zum Lesen von Daten vom Client
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String command;

            // Lesen und Verarbeiten von Befehlen, die vom Client gesendet werden
            while ((command = bufferedReader.readLine()) != null) {
                System.out.println(command);

                // Wenn der Befehl "TIME" empfangen wird, sende die aktuelle Zeit an den Client
                if ("TIME".equals(command)) {
                    Calendar cal = GregorianCalendar.getInstance();
                    bufferedWriter.write(cal.get(Calendar.HOUR_OF_DAY) + " : " + cal.get(Calendar.MINUTE) + " : " + cal.get(Calendar.SECOND));
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                // Wenn der Befehl "PORT" empfangen wird, sende den Port, auf dem der Server lauscht, an den Client
                else if ("PORT".equals(command)) {
                    bufferedWriter.write("PORT: " + socket.getLocalPort()); // -> 9090
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
                // Wenn der Befehl "END" empfangen wird, sende "BYE" und beende die Kommunikation
                else if ("END".equals(command)) {
                    bufferedWriter.write("BYE");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    break;
                }
                // Für unbekannte Befehle sende "unknown command"
                else {
                    bufferedWriter.write("unknown command");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }
            }

            // Schließen der Streams und des Sockets
            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("Beendet.");
        }
    }
}