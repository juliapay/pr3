package at.campus02.pr3.NETZWERK.URLConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class SetClientFieldsForWebsite {

    public static void main(String[] args) throws IOException {
        // Erstelle ein URL-Objekt mit der angegebenen URL
        URL urlObj = new URL("https://www.google.com");

        // Öffne eine Verbindung zu der URL
        URLConnection urlCon = urlObj.openConnection();

        // Setze verschiedene Anfrageeigenschaften (Request Properties) für die Verbindung
        // Setzt den User-Agent Header
        urlCon.setRequestProperty("User-Agent", "Java Client; Mac OS ich sascha");

        // Setzt den Accept Header, um den bevorzugten Inhaltstyp zu spezifizieren
        urlCon.setRequestProperty("Accept", "text/html");

        // Setzt den Accept-Language Header, um die bevorzugte Sprache zu spezifizieren
        urlCon.setRequestProperty("Accept-Language", "en-US");

        // Setzt den Connection Header auf "close", um anzugeben, dass die Verbindung nach der Antwort geschlossen werden soll
        urlCon.setRequestProperty("Connection", "close");

        // Gibt alle gesetzten Anfrageeigenschaften aus
        System.out.println(urlCon.getRequestProperties());
    }
}
