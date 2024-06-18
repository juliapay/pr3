package at.campus02.pr3.NETZWERK.InputURLOutputConsole;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        InputStream is = null;

        String string = null;
        try {
            // Erstellen eines URL-Objekts mit der Adresse "http://google.com"
            URL url = new URL("http://google.com");

            // Öffnen der Verbindung zur URL und Einstellen der Zeitlimits für die Verbindung
            conn = (HttpURLConnection) url.openConnection();

            // Öffnen eines InputStreams zum Lesen von Daten von der URL
            is = new BufferedInputStream(conn.getInputStream());

            // Erstellen eines BufferedReader zum Lesen von Textdaten aus dem InputStream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
// Liest die daten des html textes der seite
            // Ausgabe der URL
            System.out.println(url);

            // Lesen und Ausgabe der Daten, die von der URL empfangen werden, Zeile für Zeile
            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }

        } catch (Exception ex) {
            // Ausnahmebehandlung: Hier könnte man Logging oder Fehlerbehandlung hinzufügen
            ex.printStackTrace();
        } finally {
            // Sicherstellen, dass der InputStream geschlossen wird, falls er geöffnet wurde
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace(); // Fehler beim Schließen des InputStreams
                }
            }
            // Trennen der HTTP-Verbindung, falls sie geöffnet wurde
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}

