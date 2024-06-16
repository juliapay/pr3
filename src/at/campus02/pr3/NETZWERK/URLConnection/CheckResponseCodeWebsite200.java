package at.campus02.pr3.NETZWERK.URLConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckResponseCodeWebsite200 {

    public static void main(String[] args) throws IOException {
        // Erstelle ein URL-Objekt mit der angegebenen URL
        URL urlObj = new URL("https://www.google.com");

        // Öffne eine HTTP-Verbindung zu der URL
        HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

        // Hole den Antwortcode vom Server (z.B. 200 für OK, 404 für nicht gefunden)
        int responseCode = httpCon.getResponseCode();

        // Überprüfe, ob die Antwort vom Server nicht OK ist (HTTP_OK bedeutet 200)
        if (responseCode != HttpURLConnection.HTTP_OK) {
            // Gib eine Fehlermeldung aus, wenn der Server nicht OK antwortet
            System.out.println("Server returned response code " + responseCode + ". Download failed.");
        } else {
            // Wenn der Server OK antwortet, gib den Antwortcode aus
            System.out.println(responseCode);
        }
    }
}
