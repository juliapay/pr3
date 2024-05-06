package at.campus02.pr3.fileio.ue3;

import java.io.*;

public class Uebung10 {
    public static void main(String[] args) throws IOException {

        // Erstellt einen FileWriter mit relativem Pfad. dh datei wird in ideaProjects erstellt
        FileWriter fileWriter = new FileWriter("uebung10.txt");
        // Erstellt einen PrintWriter, der mit dem FileWriter verbunden ist


        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        // Erstellt einen BufferedReader, um den InputStreamReader zu lesen
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // Gibt die String, die in die Datei geschrieben werden sollen an
        // Liest Zeile für Zeile den Input ein, bis das Wort "STOP" eingegeben wird
        String line;
        do {
            line = bufferedReader.readLine();
            if (!line.equalsIgnoreCase("STOP")) {
                fileWriter.write(line+"\n");
                System.out.println("Fach und Note: " + line);

            }
        } while (!line.equalsIgnoreCase("STOP"));
        //--------------FLUSH--------------------------------------
        // Der PrintWriter schreibt jetzt  alle Schreibbefehle in die Datei,
        // die noch nicht geschrieben wurden,
        // jetzt definitiv in die Datei geschrieben werden
        fileWriter.flush();
        // Schließt den PrintWriter, um die Datei zu schließen
        fileWriter.close();
    }
}
