package at.campus02.pr3.NETZWERK.ClientToServer;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ListenToMultipleClients {
//    Adaptieren Sie das Server-Programm so, dass mehr als eine
//    Client-Verbindung aufgenommen werden kann. Testen Sie
//    Ihre Implementierung mit Hilfe von telnet
//    https://windowsreport.com/telnet-windows-10/
//    Via CommandLine (cmd):telnet localhost 9090
    // cmdline = client
    // java ist der server
    // 2x cmd mit: telnet localhost 9090
    // dann programm starten starten......beide
//    Verbunden mit Communication task : hier ist der
    public static void main(String[] args) {
        // hier die thread liste
        List<Thread> clients = new ArrayList<>();

        System.out.println("Starte Server ...");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9090);
            serverSocket.setSoTimeout(30000); // 30 sek zeit zum verbinden
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Thread thread = new Thread(new CommunicationTask(socket)); // Worker Class -> Runnalbe implementation
               // hier der Thread von communication task
                thread.start();
                clients.add(thread);
            } catch (SocketTimeoutException e) {
                System.out.println("Server TIMEOUT");
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//   HIER DIE LISTE FÜR DIE CLIENTS
        for (Thread t : clients) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ENDE");
    }
}

