package at.campus02.pr3.THREADS.TwoThreadsReadFromFileStoreInArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {
    public FileReadWorker(String name, String path) {
        super(name);
        this.path = path;
    }

    private String path;
    public ArrayList<String> textzeilen = new ArrayList<>();

    @Override
    protected void work() {
        printStarted();
        textzeilen.clear();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                textzeilen.add(line);
                if (!shouldRun) {
                    break;
                }
                Thread.sleep(1000);
            }
            bufferedReader.close();
            shouldRun = false;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printStopped();
    }
    @Override
    public void run() {
        work();
    }
}
