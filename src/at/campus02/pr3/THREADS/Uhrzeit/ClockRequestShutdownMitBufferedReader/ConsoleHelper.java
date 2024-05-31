package at.campus02.pr3.THREADS.Uhrzeit.ClockRequestShutdownMitBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static String readLine(){
        InputStreamReader inputStreamReader= new InputStreamReader(System.in);
        BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
