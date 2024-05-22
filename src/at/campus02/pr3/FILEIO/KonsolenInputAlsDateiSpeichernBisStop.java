package at.campus02.pr3.FILEIO;

import java.io.*;

public class KonsolenInputAlsDateiSpeichernBisStop {
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

    public static class Printwriter {
         /*
        print() Method
            print() - prints the specified data to the writer
            println() - prints the data to the writer along with a new line character at the end

        // Creates a PrintWriter using some character encoding
        PrintWriter output = new PrintWriter(String file, boolean autoFlush, Charset cs);
            Note: The PrintWriter class also has a feature of auto flushing.
                This means it forces the writer to write all data to the destination if
                one of the println() or printf() methods is called.

                BufferedWriter is more efficient if you have multiple writes between flush/close the writes are small compared with the buffer size.
    PrintWriter just exposes the print methods on any Writer in character mode.
         */

        public static void main(String[] args) throws IOException {
            FileWriter fileWriter = new FileWriter("neue_datei_18mai.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Mittels println(...) werden Zwei Zeilen geschrieben. Jede Zeile wird richtig abgeschlosen.
            printWriter.println("FirstLine");
            printWriter.println("SecondLine");
            printWriter.print(1);
            printWriter.print(2);
            printWriter.println();
            printWriter.format("This is a %s program with %d", "Hello World", 100);
            // printWriter.printf()

            // flush() löst das Schreiben aus
            // Flushing a stream ensures that all data that has been written
            // to that stream is output, including clearing any that may have been buffered.
            printWriter.flush();
            // close() gibt die Datei wieder frei
            printWriter.close();
            System.out.println("Fertig");

            //----MIT TRY CATCH EXCEPTION------

                /*
            close()	closes the print writer
            checkError()	checks if there is an error in the writer and returns a boolean result
            append()	appends the specified data to the writer
             */

                try {
                    PrintWriter printWriter1 = new PrintWriter(new FileWriter("output.txt"));

                    int age = 25;

                    printWriter1.printf("I am %d years old.", age);
                    printWriter1.println("I am " + age + " years old.");

                    printWriter1.flush();

                    System.out.println(printWriter1.checkError());

                    printWriter1.close();

                } catch (Exception e) {
                    e.getStackTrace();
                }
            }


        }
}
