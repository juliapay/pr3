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
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    int rounds = new Random().nextInt(10) + 1;
                    int count = 0;

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.equalsIgnoreCase("ping")) {
                            if (count < rounds) {
                                out.println("pong");
                                count++;
                            } else {
                                out.println("ende");
                                break;
                            }
                        } else if (inputLine.equalsIgnoreCase("stop")) {
                            System.out.println("Server stopping...");
                            out.println("Server stopped");
                            System.exit(0);
                        } else {
                            out.println("Unknown command");
                        }
                    }

                    System.out.println("Client disconnected");
                } catch (IOException e) {
                    System.out.println("Exception in client connection: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Exception in server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}