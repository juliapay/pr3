package at.campus02.pr3.FILEIO;

import java.io.*;

public class KonsoleneingabeBisStopInputStreamBReader {
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

    public static class Filewriter {
        public static void main(String args[]) {
            String data = "This is the data in the output file";

            try {
                // Creates a FileWriter
                FileWriter fileWriter = new FileWriter("neue_datei_18mai.txt");
                fileWriter.write(data);
                // Writes the string to the file
                fileWriter.flush();
                // Closes the writer
                fileWriter.close();
                System.out.println("File created.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

