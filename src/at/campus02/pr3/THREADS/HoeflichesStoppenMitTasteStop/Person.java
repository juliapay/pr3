package at.campus02.pr3.THREADS.HoeflichesStoppenMitTasteStop;

public class Person implements Runnable{
private boolean isRunning=true;
private String name;

    public Person(String name) {
        this.name = name;
    }
    public void requestShutDown(){
        isRunning=false;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            if (isRunning){
                System.out.println(name+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                break;
            }

        }

    }
}
