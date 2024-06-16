package at.campus02.pr3.NETZWERK.ReadFromURLandSaveToFile;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Main starting up...");
            System.out.println("Bitte die gewünschte URL eingeben: ");
            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));
//            String user_url = userInput.readLine();
            String user_url = "https://de.wikipedia.org/wiki/Objektorientierte_Programmierung"; // nur zum Testen
            System.out.println("Habe folgende URL bekommen: '" + user_url + "'");

            //URL auslesen
            URL myURL = new URL(user_url);
            InputStreamReader isr = new InputStreamReader(myURL.openStream());
            BufferedReader br = new BufferedReader(isr);

            //neues File
            File f = new File("content.html");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
//            BufferedWriter bw = new BufferedWriter(new FileWriter("content.html")); // alles in 1ner Zeile
            System.out.println("---Output Datei ist hier: " + f.getAbsolutePath());
            String one_line;
            //jede einzelne Zeile von Website -> auf Konsole schreiben
            while ((one_line = br.readLine()) != null) {
                System.out.println(one_line);
                bw.write(one_line);
                bw.newLine();
            }

            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
