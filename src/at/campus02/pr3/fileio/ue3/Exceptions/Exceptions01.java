package at.campus02.pr3.fileio.ue3.Exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exceptions01 {
    public static void main(String[] args) {
        // Uebung 08 aber mit Exceptions
        // Erstellt einen InputStreamReader, um den InputStream System.in zu lesen
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        // Erstellt einen BufferedReader, um den InputStreamReader zu lesen
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // Liest Zeile für Zeile den Input ein, bis das Wort "STOP" eingegeben wird
        String line;

        //------------EXCEPTIONS------------
        try {
            // Verwendet einen do-while Loop, um Zeilen aus dem BufferedReader zu lesen
            do {
                line = bufferedReader.readLine();
                System.out.println("Eingegebene Zeile: " + line);
            } while (!line.equalsIgnoreCase("STOP"));

        } catch (IOException e) {
            // catch block 1
            // Wird ausgeführt, wenn eine IOException während des Lesens der Zeilen auftritt
            e.printStackTrace();

        } finally {
            // Schließt den BufferedReader, um Ressourcen freizugeben
            try {
                bufferedReader.close();
                System.out.println("Reader erfolgreich geschlossen.");

            } catch (IOException e) {
                // Wird ausgeführt, wenn eine IOException beim Schließen des BufferedReaders auftritt
                e.printStackTrace();
            }
        }
    }
}
