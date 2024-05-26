package at.campus02.pr3.THREADS.HoeflichesStoppenMitTasteStop;

import java.util.Scanner;

public class ConsoleHelper {
    public static String readLine(){
        // InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        // BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        Scanner input= new Scanner(System.in);
        String s= input.nextLine();
        return s;
    }
}
