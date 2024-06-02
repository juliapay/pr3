package at.campus02.pr3.PROBE.PruefungChatMitThreadLogFileException;

import java.io.*;
import java.net.Socket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        Socket socket = new Socket("localhost", 2200);

        // Reader zum Einlesen der Benutzereingaben aus der Konsole
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        // Reader zum Einlesen von Nachrichten vom Server
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // Writer zum Senden von Nachrichten an den Server
        PrintWriter socketWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        File file = new File("jp_Logfile.txt");
        FileWriter fileWriter = new FileWriter(file);


        Thread threadLogFile = new Thread(new ThreadBackground(file));
        threadLogFile.start();


        // Hauptschleife zum Senden und Empfangen von Nachrichten
        while (true) {
            String userInput = "";
            // Prüfe, ob eine Nachricht vom Server empfangen wurde
            while (userInputReader.ready()) {
                userInput = userInputReader.readLine();
                socketWriter.println("--->DATEN GESENDET VOM USER: " + userInput);
                System.out.println("--->DATEN GESENDET VOM USER: " + userInput);
                socketWriter.flush();
                fileWriter.write("--->DATEN GESENDET VOM USER: " + userInput+"\n");
                fileWriter.flush();
            }
            if (userInput.equalsIgnoreCase("ende")) {
                System.out.println("User requested shutdown");
                threadLogFile.interrupt();
                fileWriter.close();
                //System.exit(0);
                break;
            }
            if (socketReader.ready()) {
                String serverResponse = socketReader.readLine();
                System.out.println("<---DATEN VOM CHAT " + serverResponse);
                //schreiben in datei
                fileWriter.write("<---DATEN VOM CHAT " + serverResponse + "\n");
                fileWriter.flush();
            }

            Thread.sleep(1000);


        }
    }
}

