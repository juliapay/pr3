package at.campus02.pr3.FILEIO.InternetadresseLesen;

import java.io.*;
import java.net.URL;

public class VonDateiURLLesenInDateiContentVonSiteSchreiben {
    public static void main(String[] args) throws IOException {
        //   Erstellen Sie ein Programm, das eine Internetadresse aus einer Textdatei liest, und den Inhalt dieser URL in eine
        //   Datei “content.html” schreibt.

        String filePath = "C:\\Users\\s54828\\Desktop\\url.txt";
        String outputfile = "C:\\Users\\s54828\\Desktop\\content.html";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String urlString = bufferedReader.readLine();//liest die erste Zeile

        bufferedReader.close();// muss geschlossen werden,da neuer bufferedReader geöffnet wird
        URL url = new URL(urlString);//text der url.txt wird in eine url verwandelt
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));//liest den html text der seite, die im url.txt steht

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputfile));
//schreiben aus dem netz in die datei
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
