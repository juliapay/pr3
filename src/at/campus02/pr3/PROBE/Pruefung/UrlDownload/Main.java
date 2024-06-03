package at.campus02.pr3.PROBE.Pruefung.UrlDownload;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        String outputfile = "content.html";

        URL url = new URL("https://de.wikipedia.org/wiki/Objektorientierte_Programmierung");//text der url.txt wird in eine url verwandelt
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));//liest den html text der seite, die im url.txt steht

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputfile));

        String inputfile;//variable für den html content der seite
        while ((inputfile = in.readLine()) != null) {//schleife solange bis kein content mehr im html file ist
            bufferedWriter.write((inputfile));//schreibt den content in das vorgegeben file
            bufferedWriter.newLine();//Zeilenumbruch
        }
        bufferedWriter.flush();
        in.close();
        bufferedWriter.close();
    }
    }

