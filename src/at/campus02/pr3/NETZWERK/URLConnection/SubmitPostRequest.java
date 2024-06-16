package at.campus02.pr3.NETZWERK.URLConnection;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SubmitPostRequest {

    public static void main(String[] args) {
        // Definiere die URL, die E-Mail und das Passwort als Strings
        String url = "https://wikipedia.org/";
        String email = "yourname@gmail.com";
        String password = "yourpass";

        try {
            // Erstelle ein URL-Objekt mit der angegebenen URL
            URL urlObj = new URL(url);

            // Öffne eine HTTP-Verbindung zu der URL
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            // Erlaube die Ausgabe der Verbindung (für POST-Daten)
            httpCon.setDoOutput(true);

            // Setze die HTTP-Methode auf POST
            httpCon.setRequestMethod("POST");

            // Erstelle die Parameterkette mit Benutzernamen und Passwort
            String parameters = "username=" + email;
            parameters += "password=" + password;

            // Erstelle einen OutputStreamWriter, um die Parameter zu schreiben
            OutputStreamWriter writer = new OutputStreamWriter(httpCon.getOutputStream());
            // Schreibe die Parameter
            writer.write(parameters);
            // Leere den Writer-Puffer und schließe die Verbindung
            writer.flush();

            // Gib den Antwortcode des Servers aus
            System.out.println("Response Code: " + httpCon.getResponseCode());

        } catch (IOException e) {
            // Fange IOExceptions ab und gib den Stacktrace aus
            e.printStackTrace();
        }
    }
}
