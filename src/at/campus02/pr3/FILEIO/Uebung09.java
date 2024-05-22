package at.campus02.pr3.FILEIO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Uebung09 {
    public static void main(String[] args) throws IOException {
        String dateipfad = "C:\\campus02\\test\\uebung09.txt";
        // Creates the directory if it doesn't exist

        File file = new File(dateipfad);
        // Erstellt einen FileWriter
        FileWriter fileWriter = new FileWriter(dateipfad);
        fileWriter.write("zeile 1" + System.getProperty(""));
        // Erstellt einen PrintWriter, der mit dem FileWriter verbunden ist
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Gibt die String, die in die Datei geschrieben werden sollen an
        printWriter.println("Hello");
        printWriter.println("zeile 3");
        //--------------FLUSH--------------------------------------
        // Der PrintWriter schreibt jetzt  alle Schreibbefehle in die Datei,
        // die noch nicht geschrieben wurden,
        // jetzt definitiv in die Datei geschrieben werden
        printWriter.flush();
        // Schließt den PrintWriter, um die Datei zu schließen
        printWriter.close();
    }
}
