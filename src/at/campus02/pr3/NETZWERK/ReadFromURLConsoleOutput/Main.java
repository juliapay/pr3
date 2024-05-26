package at.campus02.pr3.NETZWERK.ReadFromURLConsoleOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Main starting up...");
            System.out.println("Bitte die gewünschte URL eingeben: ");
            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));
            String user_url = userInput.readLine();
            System.out.println("Habe folgende URL bekommen: '" + user_url + "'");

            //URL auslesen
            URL myURL = new URL(user_url);
            InputStreamReader isr = new InputStreamReader(myURL.openStream());
            BufferedReader br = new BufferedReader(isr);
            String one_line;

            //jede Zeile von Website -> auf Konsole schreiben
            while ((one_line = br.readLine()) != null) {
                System.out.println(one_line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
