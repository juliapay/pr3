package at.campus02.pr3.PROBE.Pruefung.BinaerFile;

import java.io.FileOutputStream;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        // Name der Datei
        String fileName = "hallo.txt";

        // Binärwert, der geschrieben werden soll
        byte value = 0x2B;

        // Datei schreiben
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            for (int i = 0; i < 20; i++) {
                fos.write(value);
            }
            System.out.println("Datei erfolgreich geschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }
    }
}
