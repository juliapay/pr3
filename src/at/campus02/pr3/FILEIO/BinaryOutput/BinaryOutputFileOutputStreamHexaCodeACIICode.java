package at.campus02.pr3.FILEIO.BinaryOutput;

import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryOutputFileOutputStreamHexaCodeACIICode {
    public static void main(String[] args) throws IOException {
       // File file = new File("C:\\campus02\\test\\testBinary2.txt");

        // Schreibt in die Datei "C:\campus02\test\testBinary2.txt"
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\campus02\\test\\testBinary2.txt");
//schreibt in die Datei mit Binär zahlen
        // Definiert eine Zeichenkette mit Daten
        String data = "hello File - second output";

        // Konvertiert die Zeichenkette in ein Char-Array
        for (char c : data.toCharArray()) {
            // Schreibt jedes Zeichen einzeln in die Datei
            fileOutputStream.write(c);
        }
        // CHAR IM ASCII CODE
        fileOutputStream.write(255);
        //CHAR im HEXADEZIMALSYSTEM
        fileOutputStream.write(0xFD);

        // Spült den Puffer, um sicherzustellen, dass alle Daten geschrieben werden
        fileOutputStream.flush();

        // Schließt den FileOutputStream, um die Ressourcen freizugeben
        fileOutputStream.close();
    }
}
