package at.campus02.pr3.FILEIO.BinaryInput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryInputLiestDateiEinAusgabeInKonsole {
    public static void main(String[] args) throws IOException {
        // Pfad der Datei
        String filePath = "C:\\campus02\\test\\test.txt";
        // Öffnet den Datei-InputStream mit dem Pfad
        FileInputStream fileInputStream = new FileInputStream(filePath);
        // Buffert die Eingabe, um die Leistung zu verbessern
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // Liest Binär ein und gibt aus in Konsole
        int byteRead;
        int i = 0;
        int j = 0;
        // Solange es noch Bytes gibt, die gelesen werden können
        //ausgegeben wird 1 Byte auf einmal = 8 Bit = 1 char
        // -1 ist end of file
        while ((byteRead = bufferedInputStream.read()) != -1) {
            // Gib das Byte auf der Konsole aus
           // char[] ch = Character.toChars(byteRead);
           // System.out.println(ch);
            System.out.print(i + ": ");
            System.out.print(byteRead);
            System.out.println("\t" + "'" + (char) byteRead + "'");
            //WHITESPACE
            if (Character.isWhitespace((char) byteRead)) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(i + " Zeichen wurden gelesen");

        System.out.println(j + " Leerzeichen oder Tabulatoren oder Zeilenumbrueche wurden eingelesen");
        // Schließt den Buffered-InputStream, um die Ressourcen freizugeben
        bufferedInputStream.close();
    }
}
