package at.campus02.pr3.NETZWERK.URLConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class ReadHtmlFieldsFromWebside {
    // Hauptmethode, die das Programm startet
    public static void main(String[] args) throws IOException {
        // Definiere die URL als String
        String url = "https://google.com";

        // Erstelle ein URL-Objekt mit der angegebenen URL
        URL urlObj = new URL(url);

        // Öffne eine Verbindung zu der URL
        URLConnection urlCon = urlObj.openConnection();

        // Hole die Headerfelder der Verbindung und speichere sie in einer Map
        Map<String, List<String>> map = urlCon.getHeaderFields();

        // Durchlaufe die Schlüssel (Header-Namen) in der Map
        for (String key : map.keySet()) {
            // Gib den Header-Namen aus
            System.out.println(key + ":");

            // Hole die Liste der Werte für den aktuellen Header-Namen
            List<String> values = map.get(key);

            // Durchlaufe die Werte für den aktuellen Header-Namen
            for (String aValue : values) {
                // Gib jeden Wert mit einem Tabulator als Einzug aus
                System.out.println("\t" + aValue);
            }
        }
    }
}
