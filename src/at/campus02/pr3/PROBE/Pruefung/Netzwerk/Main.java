package at.campus02.pr3.PROBE.Pruefung.Netzwerk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hallo, hier ist das Netzwerk-Projekt");

        ServerSocket server = new ServerSocket(8787);
        //Port geöffnet erstellen des serverSockets
        //Port 0-ca 1100 sind reserviert


         while (true) {
            Socket socket = server.accept();//Listen to Client!
             BufferedWriter bufferedWriter =
                     new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader bufferedReader
                     = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             System.out.println("Ein Client hat sich verbunden");
             bufferedWriter.write("Hallo Client");
             bufferedWriter.newLine();
             bufferedWriter.write("Gib einen Buchstaben ein");
             String command;
            while ((command = bufferedReader.readLine()) != null) {

                if ("h".equalsIgnoreCase(command)) {
                    bufferedWriter.write("Das ist die Hilfe");

                }
                if ("q".equalsIgnoreCase(command)) {
                    bufferedWriter.write("Auf Wiedersehen");
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    System.out.println("Ende Des Netzwerk-Projekts");
                    System.exit(0);// beendet das programm
                }


            }
        }
    }
}
