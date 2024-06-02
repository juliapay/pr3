package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.example1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenToClient2 {
    public static void main(String[] args) {
        int port = 1111;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Exception in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
