package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.chatMitThread;

import java.io.File;

public class BackgroundThread implements Runnable{
    File logFile;
    public BackgroundThread(File logfile) {
        this.logFile=logfile;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            System.out.println(logFile.length());


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new LogFileException(e.getMessage());
            }

        }
    }
}
