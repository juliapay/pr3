package at.campus02.pr3.FILEIO.Uebung14;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Uebung14c {
    public static void main(String[] args) throws IOException {


        // Schreibt in die Datei "C:\campus02\test\testBinary3.txt"
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\campus02\\test\\testBinary3.txt");

        // Verwendet einen Puffer, um die Leistung zu verbessern
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        // Definiert eine Zeichenkette mit Daten
        String data = "hello File - öäü";

        // Schreibt die Daten in den Puffer
        bufferedOutputStream.write(data.getBytes(StandardCharsets.ISO_8859_1));
        // Schreibt die gleiche zeile ohne charsetzuweisung
        bufferedOutputStream.write(System.lineSeparator().getBytes());
        bufferedOutputStream.write(data.getBytes());


        // Schreibt zwei Bytes mit den Werten 255 und 253 in den Puffer
        bufferedOutputStream.write(255);
        bufferedOutputStream.write(0xFD);

        // Spült den Puffer, um sicherzustellen, dass alle Daten geschrieben werden
        bufferedOutputStream.flush();

        // Schließt den BufferedOutputStream, um die Ressourcen freizugeben
        bufferedOutputStream.close();
    }
}
