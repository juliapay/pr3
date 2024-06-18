package at.campus02.pr3.THREADS.TwoThreadsReadFromFileStoreInArray;

public class Demo {
    public static void main(String[] args) {
        TimePrintWorker p1 = new TimePrintWorker("TimePrint");
        FileReadWorker f1 = new FileReadWorker("FileRead", "C:\\Users\\Julia\\julia\\workingwoman\\SWENG C&M\\SWENG\\FH CAMPUS 02\\Seminare\\Programmieren 3\\UEBUNGENFUERPRUEFUNG\\test\\uebung_11\\uebung11.txt");
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(f1);
        t1.start();
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (f1.shouldRun == false) {
            p1.stopWorker();
        }
    }
}
