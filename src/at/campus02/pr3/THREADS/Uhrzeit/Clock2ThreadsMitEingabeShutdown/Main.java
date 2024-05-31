package at.campus02.pr3.THREADS.Uhrzeit.Clock2ThreadsMitEingabeShutdown;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("MAIN: Starting up.");

        // Erstellt zwei Instanzen der Clock-Klasse.
        Clock c1 = new Clock();
        Clock c2 = new Clock();

        // Erstellt zwei Threads und weist ihnen die Clock-Instanzen zu.
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        // Startet die beiden Threads.
        t1.start();
        t2.start();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Wartet auf eine Eingabe vom Benutzer.
        try {
            String input = bufferedReader.readLine();
            if (input != null) {
                c1.requestShutDown();
            }
            if (input != null) {
                c2.requestShutDown();
            }
            t1.join();
            t2.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main: reached end.");
    }
}

