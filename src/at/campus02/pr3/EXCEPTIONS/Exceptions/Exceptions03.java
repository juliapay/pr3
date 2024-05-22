package at.campus02.pr3.EXCEPTIONS.Exceptions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exceptions03 {
    public static void main(String[] args) {
        // Pfad der Datei
        String filePath = "C:\\campus02\\test\\test.txt";
        // Deklaration außerhalb des try-Blocks
        BufferedInputStream bufferedInputStream = null;

        try {
            // Öffnet den Datei-InputStream mit dem Pfad
            FileInputStream fileInputStream = new FileInputStream(filePath);
            // Buffert die Eingabe, um die Leistung zu verbessern
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            // Variable zum Speichern des gelesenen Bytes
            int byteRead;
            int i = 0;
            // Solange es noch Bytes gibt, die gelesen werden können
            // wird 1 Byte auf einmal = 8 Bit = 1 char ausgegeben
            // -1 ist end of file
            while ((byteRead = bufferedInputStream.read()) != -1) {
                // Gib das Byte auf der Konsole aus
                System.out.print(i + ": ");
                System.out.print(byteRead);
                System.out.println("\t" + (char) byteRead + "'");
                if (i >= 9) {
                    break;
                }
                i++;
            }
            //Überprüfen der Exceptions
          //  throw new FileNotFoundException();
        } catch (IOException e) {
            // Prüft, ob die Exception ein FileNotFoundException ist
            if (e instanceof FileNotFoundException){
                System.err.println("Dies war ein FileNotFoundException");
                //user auffordern einen neuenPfad einzugeben
            }else{
                System.err.println("Dies war eine andere Exception");
            }
            // Wird ausgeführt, wenn die Datei nicht gefunden wird
            e.printStackTrace();
        } finally {
            try {
                // Schließt den Buffered-InputStream, um die Ressourcen freizugeben
                bufferedInputStream.close();
            } catch (IOException e) {
                // Wird ausgeführt, wenn eine IOException beim Schließen des Buffered-InputStreams auftritt
                e.printStackTrace();
            }
        }
    }
}
