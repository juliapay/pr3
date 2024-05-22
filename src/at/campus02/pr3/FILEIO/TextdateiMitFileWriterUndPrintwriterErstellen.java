package at.campus02.pr3.FILEIO;

import java.io.*;
import java.nio.charset.Charset;

public class TextdateiMitFileWriterUndPrintwriterErstellen {
    public static void main(String[] args) throws IOException {
        String dateipfad = "C:\\Users\\Julia\\julia\\workingwoman\\SWENG C&M\\SWENG\\FH CAMPUS 02\\Seminare\\test\\pr3\\src\\at\\campus02\\pr3\\uebung09.txt";
        // Creates the directory if it doesn't exist

        File file = new File(dateipfad);
        // Erstellt einen FileWriter
        FileWriter fileWriter = new FileWriter(dateipfad);
        fileWriter.write("zeile 1" + System.getProperty(""));
        // Erstellt einen PrintWriter, der mit dem FileWriter verbunden ist
        PrintWriter printWriter = new PrintWriter(fileWriter);
        // Gibt die String, die in die Datei geschrieben werden sollen an
        printWriter.println("Hello");
        printWriter.println("zeile 3");
        //--------------FLUSH--------------------------------------
        // Der PrintWriter schreibt jetzt  alle Schreibbefehle in die Datei,
        // die noch nicht geschrieben wurden,
        // jetzt definitiv in die Datei geschrieben werden
        printWriter.flush();
        // Schließt den PrintWriter, um die Datei zu schließen
        printWriter.close();
                   /*
    Methods of BufferedWriter
        The BufferedWriter class provides implementations for different methods present in Writer.
    write() Method
    write() - writes a single character to the internal buffer of the writer
    write(char[] array) - writes the characters from the specified array to the writer
    write(String data) - writes the specified string to the writer
     */
        FileWriter fileWriter1 = new FileWriter("neue_datei_18mai.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter1);
        // BufferedWriter bufferedReader = new BufferedWriter(new FileWriter("neue_datei_18mai.txt"));

        String data = "Das ist ein test";
        bufferedWriter.write(data);
        bufferedWriter.write(data);
        bufferedWriter.newLine();
        bufferedWriter.write(data);
        bufferedWriter.flush();
        bufferedWriter.close();
        System.out.println("Fertig");
    }

    public static class Outputstreamwriter {
        public static void main(String[] args) throws IOException {
            String data = "example";

            FileOutputStream file = new FileOutputStream("output.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file);

            outputStreamWriter.write(data);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            //---MIT TRY CATCH---
            try {
                // Creates an output stream
                FileOutputStream file1 = new FileOutputStream("output.txt");

                // Creates an output stream reader with default encoding
                OutputStreamWriter output1 = new OutputStreamWriter(file1);

                // Creates an output stream reader specifying the encoding
                OutputStreamWriter output2 = new OutputStreamWriter(file1, Charset.forName("UTF8"));

                // Returns the character encoding of the output stream
                System.out.println("Character encoding of output1: " + output1.getEncoding());
                System.out.println("Character encoding of output2: " + output2.getEncoding());

                // Closes the reader
                output1.close();
                output2.close();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
