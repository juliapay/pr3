package at.campus02.pr3.FILEIO;

import java.io.*;

public class Uebung08 {
    public static void main(String[] args) throws Exception {

        // Erstellt einen InputStreamReader, um den InputStream System.in zu lesen
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        // Erstellt einen BufferedReader, um den InputStreamReader zu lesen
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // Liest Zeile für Zeile den Input ein, bis das Wort "STOP" eingegeben wird
        String line;
        do {
            line = bufferedReader.readLine();
            System.out.println("Eingegebene Zeile: " + line);
        } while (!line.equalsIgnoreCase("STOP"));

        // Schließt den BufferedReader, um Ressourcen freizugeben
        bufferedReader.close();

    }
}

