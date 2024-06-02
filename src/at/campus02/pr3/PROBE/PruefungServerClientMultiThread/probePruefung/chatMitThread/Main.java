package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.chatMitThread;

import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 2200);
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader chatReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter chatOutputWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        File logFile = new File("logfile_jp.txt");
        FileWriter logFileWriter = new FileWriter(logFile);
        Thread thread = new Thread(new BackgroundThread(logFile));
        thread.start();

        while (true) {
            String userInput = "";

            while (userInputReader.ready()) {
                userInput = userInputReader.readLine();
                chatOutputWriter.println("---> Daten gesendet vom User: " + userInput);
                System.out.println("---> Daten gesendet vom User: " + userInput);
                chatOutputWriter.flush();
                logFileWriter.write("---> Daten gesendet vom User: " + userInput + "\n");
                logFileWriter.flush();
            }
            if (userInput.equalsIgnoreCase("ende")) {
                System.out.println("User requested shutdown");
                thread.interrupt();
                logFileWriter.close();
                //System.exit(0);
                break;
            }
            if (chatReader.ready()) {
                String serverResponse = chatReader.readLine();
                System.out.println("<---Daten gesendet vom Chat: " + serverResponse);
                logFileWriter.write("<---Daten gesendet vom Chat: " + serverResponse);
                logFileWriter.flush();
            }

            Thread.sleep(1000);
        }


    }
}
