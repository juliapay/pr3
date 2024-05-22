package at.campus02.pr3.THREADS.Uhrzeit.ue03_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // Hauptmethode des Programms, die als Einstiegspunkt dient und mögliche Unterbrechungen und I/O-Fehler behandelt.
    public static void main(String[] args) throws InterruptedException, IOException {

        // Gibt eine Nachricht aus, die das Starten des Hauptprogramms ankündigt.
        System.out.println("MAIN: Starting up.");

        // Erstellt ein Objekt der Klasse Clock.
        Clock c = new Clock();
        // Erstellt einen Thread und übergibt das Clock-Objekt, damit es im Hintergrund laufen kann.
        Thread t = new Thread(c);

        // Startet den Thread, welcher die run-Methode von Clock ausführt.
        t.start();

        // Erstellt einen InputStreamReader, der System.in liest (Standardeingabe, meist die Tastatur).
        InputStreamReader isr = new InputStreamReader(System.in);
        // Verpackt den InputStreamReader in einen BufferedReader, um die Eingabezeilenweise lesen zu können.
        BufferedReader br = new BufferedReader(isr);

        // Liest eine Zeile von der Konsole. Das Programm wartet hier, bis der Benutzer etwas eingibt und Enter drückt.
        String a = br.readLine();
        // Fordert den Clock-Thread zum Stoppen auf, nachdem eine Benutzereingabe erhalten wurde.
        c.requestShutDown();

        // Gibt eine Nachricht aus, dass das Hauptprogramm sein Ende erreicht hat.
        System.out.println("Main: reached end.");
    }
}
