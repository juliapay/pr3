package at.campus02.pr3.THREADS.Uhrzeit.ue03_02_01;

import java.util.Date;

/*
rweitern Sie Ihr „Uhr-Beispiel“, sodass neben der Uhrzeit auch die Anzahl an CPUs und der noch aus Sicht von Java freie Speicher ausgegeben wird:

▪ Date d = new Date();
 ▪ System.out.print("[");
 ▪ System.out.print(d.toString());
▪ System.out.print(", CPUS: ");
▪ System.out.print(Runtime.getRuntime().availableProcessors());
 ▪ System.out.print(", FreeMem: "); ▪ System.out.print(Runtime.getRuntime().freeMemory());
▪ System.out.print("]");

 Starten Sie zwei „Uhr-Threads“ gleichzeitig
 Entdecken Sie, dass sich die beiden Threads in die Quere kommen?
 Definieren Sie die Ausgabe als „Kritische Sektion“ mit synchronized
 Führen Sie die Anwendung erneut aus und stellen sie fest, dass sich die Threads nicht mehr in die Quere kommen.
 */

public class Clock implements Runnable{


    private boolean isRunning = true;

    private static final Object lock = new Object();

    @Override
    public void run() {


        while (isRunning) {
            synchronized (lock) {
                Date d = new Date();

                System.out.print("[");
                System.out.print(d.toString());
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.println("]");
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    throw new RuntimeException(e);
                }
            }
        }
    }


    public void requestShutDown() {
        System.out.println("Thread got shutdown Request");
        isRunning = false;
    }
}
