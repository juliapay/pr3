package at.campus02.pr3.NETZWERK.ClientToServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URLConnection;

public class ZeitLesenVonServer {
    public static void main(String[] args) throws IOException, InterruptedException {

//        Schreiben Sie ein Programm, das sich mit der
//        Internetadresse time-a.timefreq.bldrdoc.gov auf Port 13
//        oder 37 verbindet und dann die aktuelle Zeit liest

            Socket socket = new Socket("time-a.timefreq.bldrdoc.gov", 13);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Reading from Server");

            System.out.println("Server first answer: " + bufferedReader.readLine());
            System.out.println("Server first answer: " + bufferedReader.readLine());
            System.out.println("Server first answer: " + bufferedReader.readLine());





    }
}