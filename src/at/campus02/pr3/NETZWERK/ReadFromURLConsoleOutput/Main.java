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
            // BufferedReader zum Lesen der Benutzereingabe von der Konsole
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            // Lesen der URL, die der Benutzer eingegeben hat
            String user_url = userInput.readLine();
            System.out.println("Habe folgende URL bekommen: '" + user_url + "'");

            // Erstellen eines URL-Objekts mit der vom Benutzer eingegebenen URL
            URL myURL = new URL(user_url);

            // Erstellen eines InputStreamReader und BufferedReader zum Lesen des Inhalts der URL
            InputStreamReader isr = new InputStreamReader(myURL.openStream());
            BufferedReader br = new BufferedReader(isr);
            String one_line;

            // Lesen jeder Zeile des Inhalts der URL und Ausgabe auf der Konsole
            while ((one_line = br.readLine()) != null) {
                System.out.println(one_line);
            }

            // Schließen der Reader
            br.close();
            isr.close();

        } catch (IOException e) {
            // Fehlerbehandlung: Wenn ein IOException auftritt, wird eine RuntimeException geworfen
            throw new RuntimeException(e);
        }
    }
}