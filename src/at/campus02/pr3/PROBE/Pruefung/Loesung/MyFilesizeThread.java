package at.campus02.pr3.PROBE.Pruefung.Loesung;

import java.io.File;

public class MyFilesizeThread implements Runnable {
    File logfileFromMain;

    public MyFilesizeThread(File logfileToSize) {
        this.logfileFromMain = logfileToSize;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            //File localLogFile = new File("logfile.txt");
            System.out.println("FILSIZE: " +
                    //localLogFile.length() + "( i am thread)" +
                    logfileFromMain.length() + " (Name:  " +
                    Thread.currentThread().getName() + ")");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Schlaf wurde unterbrochen, beende mich.");
                //throw new RuntimeException(e);

                //wrapping would be: (down not work here, but in priciple)
                //throw new LogFileException(e.getMessage());
                break;
            }
        }
    }
}
