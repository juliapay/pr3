package at.campus02.pr3.fileio.ue3;

import java.io.*;

public class Uebung12 {

    public static void main(String[] args) throws IOException {


        // Pfad der Datei
        String filePath = "C:\\campus02\\test\\test.txt";

        // Öffnet den Datei-InputStream mit dem Pfad
        FileInputStream fileInputStream = new FileInputStream(filePath);

        // Buffert die Eingabe, um die Leistung zu verbessern
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        // Variable zum Speichern des gelesenen Bytes
        int byteRead;
        int i = 0;
        // Solange es noch Bytes gibt, die gelesen werden können
        //ausgegeben wird 1 Byte auf einmal = 8 Bit = 1 char
        // -1 ist end of file
        while ((byteRead = bufferedInputStream.read()) != -1) {
            // Gib das Byte auf der Konsole aus
            System.out.print(i+": ");
            System.out.print(byteRead);
            System.out.println("\t"+(char) byteRead+"'");
            if (i >= 9) {
                break;
            }
            i++;
        }
        // Schließt den Buffered-InputStream, um die Ressourcen freizugeben
        bufferedInputStream.close();
    }
}
