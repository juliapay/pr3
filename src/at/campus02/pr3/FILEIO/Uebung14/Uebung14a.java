package at.campus02.pr3.FILEIO.Uebung14;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Uebung14a {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream output = new PrintStream("C:\\campus02\\test\\testBinary.txt");
        String data = "hello File - first output";
        output.print(data);

        output.flush();
        output.close();
    }
}
