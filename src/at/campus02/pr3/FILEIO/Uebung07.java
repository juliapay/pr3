package at.campus02.pr3.FILEIO;

import java.io.*;
import java.io.File;

public class Uebung07 {
    public static void main(String[] args) throws IOException {
        // Erstellt ein File-Objekt, das die Datei darstellt, die gelesen werden soll
        File file = new File("C:\\campus02\\test\\test.txt");

        // Erstellt ein FileReader-Objekt, um den Inhalt der Datei zu lesen
        FileReader fileReader = new FileReader(file);

        // Erstellt ein BufferedReader-Objekt, um den Inhalt der Datei Zeile für Zeile zu lesen
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Liest den Inhalt der Datei Zeile für Zeile und gibt ihn in der Konsole aus
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // Schließt das BufferedReader-Objekt, um Ressourcen freizugeben
        bufferedReader.close();

    }
}