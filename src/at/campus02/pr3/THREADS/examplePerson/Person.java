package at.campus02.pr3.THREADS.examplePerson;

public class Person implements Runnable {

    private String name;

    public Person(String name) {
        this.name = name;
    }


    // Implementiert die run-Methode, die beim Start des Threads aufgerufen wird.
    @Override
    public void run() {
        // Schleife, die zehnmal durchläuft.
        for (int i = 0; i < 10; i++) {
            // Gibt den Namen der Person und den Namen des aktuell ausführenden Threads aus.
            System.out.println("Person " + name + " und mein Thread heißt: " + Thread.currentThread().getName() + "'");
            try {
                // Der aktuelle Thread schläft für 1000 Millisekunden (1 Sekunde).
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Wirft eine RuntimeException, falls der Thread unterbrochen wird.
                throw new RuntimeException(e);
            }

        }
    }
}
