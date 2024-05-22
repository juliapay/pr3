package at.campus02.pr3.FILEIO;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileoutputstreamEinlesenVonEinzelnenZeichenVonKonsoleSchreibenInDatei {
    public static void main(String[] args) throws IOException {
    /*

    Java FileOutputStream is an output stream used for writing data to a file.

    If you have to write primitive values into a file,
    use FileOutputStream class. You can write byte-oriented as
    well as character-oriented data through FileOutputStream class.
    But, for character-oriented data, it is preferred to use FileWriter
    than FileOutputStream.

     */

        // Schreibt in die Datei "C:\campus02\test\testBinary4.txt"
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\campus02\\test\\testBinary4.txt");

        // Liest ein Zeichen von der Konsole und speichert es in der Variablen c
        char c;
        // die bedingung wird als erstes ausgeführt = muss true sein
        // dh er liest immer neu ein!!!
        while ((c = (char) System.in.read()) != 'x') {

            // Gibt das gelesene Zeichen aus
            System.out.println(c);

            // Schreibt das Zeichen als Byte in die Datei
            fileOutputStream.write(c);
        }

        // Gibt eine Meldung aus, wenn ein 'x' eingegeben wird
        System.out.println("Es kam ein x ");

        // Spült den Puffer, um sicherzustellen, dass alle Daten geschrieben werden
        fileOutputStream.flush();

        // Schließt den FileOutputStream, um die Ressourcen freizugeben
        fileOutputStream.close();
    }
}
