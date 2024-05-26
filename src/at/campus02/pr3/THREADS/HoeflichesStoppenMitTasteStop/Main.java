package at.campus02.pr3.THREADS.HoeflichesStoppenMitTasteStop;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Pablo");
        Person p2 = new Person("Mia");
        Thread t1= new Thread(p1);
        Thread t2= new Thread(p2);

        System.out.println("press a key to stop the threads!");
        t1.start();
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());

        if(ConsoleHelper.readLine() !=null){
            p1.requestShutDown();
            System.out.println(t1.getState());
            System.out.println(t2.getState());
        }
        if(ConsoleHelper.readLine() !=null){
            p2.requestShutDown();
            System.out.println(t1.getState());
            System.out.println(t2.getState());
        }
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("E" +
                " ende Gelände");
    }
}
