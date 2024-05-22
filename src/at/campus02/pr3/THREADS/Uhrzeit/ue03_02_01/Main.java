package at.campus02.pr3.THREADS.Uhrzeit.ue03_02_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("MAIN: Starting up.");

        Clock c1 = new Clock();
        Clock c2 = new Clock();

        // Erstellt zwei Threads und weist ihnen die Clock-Instanzen zu.
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        // Startet die beiden Threads.
        t1.start();
        t2.start();

        // Lässt den Hauptthread warten, bis eine Eingabe erfolgt, um die Threads zu stoppen.
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        // Wartet auf eine Eingabe vom Benutzer.
        String a = br.readLine();
        // Fordert die Threads auf, sich zu beenden.
        c1.requestShutDown();
        c2.requestShutDown();

        // Wartet, bis beide Threads beendet sind.
        t1.join();
        t2.join();

        System.out.println("Main: reached end.");
    }
}
