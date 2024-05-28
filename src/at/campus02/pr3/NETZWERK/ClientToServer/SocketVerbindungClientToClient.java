package at.campus02.pr3.NETZWERK.ClientToServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SocketVerbindungClientToClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("bernhardfuchs.at", 40005);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Reading from Server");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String command;
        while ((command = bufferedReader.readLine()) != null) {
            if ("ping".equals(command)) {
                bufferedWriter.write("pong");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }else if ("stop".equals(command)) {
                bufferedWriter.write("BYE");
                bufferedWriter.newLine();
                bufferedWriter.flush();
                break;
            }else {
                bufferedWriter.write("unknown command");
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            bufferedReader.close();
            bufferedWriter.close();

        }
    }
}
