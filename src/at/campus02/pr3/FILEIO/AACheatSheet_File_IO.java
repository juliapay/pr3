package at.campus02.pr3.FILEIO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class AACheatSheet_File_IO {
    public static void main(String[] args) throws IOException {

        //----FILE MIT BUFFEREDREADER EINLESEN AUSGABE IN KONSOLE----
        // öffnet die Datei test.txt
        File file = new File("umlaute.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);

        //----FILE MIT BUFFEREDREADER EINLESEN AUSGABE IN KONSOLE----
        //----KURZFORMEN-------
        BufferedReader br2 = new BufferedReader(new FileReader(new File("testout.txt")));
        BufferedReader br3 = new BufferedReader(new FileReader("testout.txt"));

        String line;
        while ((line = bufferedReader1.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader1.close();

        //----BUFFEREDREADER INPUTSTREAM  EINGABE UEBER KONSOLE BIS STOP----
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line1;
        while (!(line1 = bufferedReader.readLine()).equals("STOP")) {
            System.out.println(line1);
        }
        bufferedReader.close();
        System.out.println("Closed");

        //----TEXTDATEI MIT FILEWRITER UND PRINTWRITER ERSTELLEN-----
        String dateipfad = "C:\\Users\\Julia\\julia\\workingwoman\\SWENG C&M\\SWENG\\FH CAMPUS 02\\Seminare\\test\\pr3\\src\\at\\campus02\\pr3\\uebung09.txt";
        File file1 = new File(dateipfad);
        FileWriter fileWriter = new FileWriter(dateipfad);
        fileWriter.write("zeile 1" + System.getProperty(""));
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println("Hello");
        printWriter.println("zeile 3");
        printWriter.flush();
        printWriter.close();

        //----TEXTDATEI ERSTELLEN DURCH KONSOLENINPUT BIS STOP-----
        FileWriter fileWriter1 = new FileWriter("uebung10.txt");
        InputStreamReader inputStreamReader1 = new InputStreamReader(System.in);
        BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader1);
        PrintWriter printWriter1 = new PrintWriter(fileWriter1);
        System.out.println("Bitte geben Sie ihr Fach sowie Note ein:");
        String line2;
        do {
            line2 = bufferedReader2.readLine();
            if (!line2.equalsIgnoreCase("STOP")) {

                fileWriter1.write(line2 + "\n");
                //ODER
                printWriter1.println(line2);

                System.out.println("Fach und Note: " + line2);
            }
        } while (!line2.equalsIgnoreCase("STOP"));
        fileWriter.flush();
        fileWriter.close();
        printWriter.flush();
        printWriter.close();
        bufferedReader.close();

        //---OUTPUTSTREAMWRITER----

        String data = "example";

        FileOutputStream file3 = new FileOutputStream("output.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(file3);

        outputStreamWriter.write(data);
        outputStreamWriter.flush();
        outputStreamWriter.close();
        try {
            FileOutputStream file4 = new FileOutputStream("output.txt");
            OutputStreamWriter output1 = new OutputStreamWriter(file4);

            OutputStreamWriter output2 = new OutputStreamWriter(file4, Charset.forName("UTF8"));
            System.out.println("Character encoding of output1: " + output1.getEncoding());
            System.out.println("Character encoding of output2: " + output2.getEncoding());

            output1.close();
            output2.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

        //----PRINTWRITER------
        FileWriter fileWriter3 = new FileWriter("neue_datei_18mai.txt");
        PrintWriter printWriter3 = new PrintWriter(fileWriter3);

        // Mittels println(...) werden Zwei Zeilen geschrieben. Jede Zeile wird richtig abgeschlosSen.
        printWriter3.println("FirstLine");
        printWriter3.println("SecondLine");
        printWriter3.print(1);
        printWriter3.print(2);
        printWriter3.println();
        printWriter3.format("This is a %s program with %d", "Hello World", 100);
        printWriter3.flush();
        printWriter3.close();
        System.out.println("Fertig");

        //---MIT TRY CATCH PRINTWRITER-----
        try {
            PrintWriter printWriter2 = new PrintWriter(new FileWriter("output.txt"));

            int age = 25;

            printWriter2.printf("I am %d years old.", age);
            printWriter2.println("I am " + age + " years old.");

            printWriter2.flush();

            System.out.println(printWriter2.checkError());

            printWriter2.close();

        } catch (Exception e) {
            e.getStackTrace();
        }

        //----BINARYINPUT MIT FILEINPUTSTREAM BUFFEREDINPUTSTREAM----
        File file6 = new File("test.txt");

        FileInputStream fileInputStream = new FileInputStream(file6);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int byteRead;
        int i=0;
        while ((byteRead = bufferedInputStream.read()) != -1) {
            System.out.print((int) ((char) byteRead));
            System.out.println("\t'" + (char) byteRead + "'");
            i++;
        }
        bufferedInputStream.close();

        //----BINARY INPUT AUS DATEI OUTPUT IN KONSOLE----
        //---ZAEHLEN ALLER ZEICHEN UND AUSGABE DER GESAMTZAHL---

        File file7 = new File("test-output.txt");
        FileInputStream fileInputStream6 = new FileInputStream(file7);
        BufferedInputStream bufferedInputStream6 = new BufferedInputStream(fileInputStream6);

        int byteRead1;
        int character_count = 0;
        while ((byteRead1 = bufferedInputStream6.read()) != -1) {
            if (!Character.isWhitespace((char) byteRead1)) {
                System.out.println((char) byteRead1);
                character_count++;
            }
        }
        System.out.println(character_count);
        bufferedInputStream6.close();

        //----BINARY OUTPUT PRINTSTREAM----
        PrintStream output = new PrintStream("C:\\campus02\\test\\testBinary.txt");
        String data2 = "hello File - first output";
        output.print(data2);

        output.flush();
        output.close();
        //----BINARY OUTPUT FILEOUTPUTSTREAM---

        File file8 = new File("test-output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file8);


        String outputText = "Hello File - first output";
        for (char c : outputText.toCharArray()) {
            fileOutputStream.write(c);
        }

        fileOutputStream.flush();
        fileOutputStream.close();

        //---BINARY OUTPUT BUFFERED OUTPUT STREAM----

        File file9 = new File("test.neu");
        FileOutputStream fileOutputStream9 = new FileOutputStream(file9);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream9);

        bufferedOutputStream.write("Hello World".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write("New - line".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.flush();
        bufferedOutputStream.close();

        //---FILE OUTPUT STREAM EINLESEN VON DER KONSOLE SCHREIBE IN DATEI----

        File file99 = new File("test-output.txt");
        FileOutputStream fileOutputStream99 = new FileOutputStream(file99);

        char c;
        while ((c = (char) System.in.read()) != 'x') {
            fileOutputStream99.write(c);
            System.out.println(c);
        }
        fileOutputStream99.flush();
        fileOutputStream99.close();
        System.out.println("Closed");
    }


    }





