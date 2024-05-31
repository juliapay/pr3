package at.campus02.pr3.THREADS.Uhrzeit.ClockRequestShutdownMitBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("MAIN: Starting up.");
        ConsoleHelper consoleHelper = new ConsoleHelper();
        Clock c = new Clock();
        Thread t = new Thread(c);

        t.start();

        System.out.println("Press key to stop....");
        if (consoleHelper.readLine() != null) {
            c.requestShutDown();
        }
        t.join();
        System.out.println("Main: reached end.");
    }
}
