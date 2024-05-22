package at.campus02.pr3.EXCEPTIONS.Exceptions.Exceptions06;

import java.io.*;

public class Exceptions06 {
    public static void main(String[] args) {

        String message = "Hallo Welt";
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            // Erstellt einen FileOutputStream für die Datei "object.dat"
            FileOutputStream fileOutputStream = new FileOutputStream("object.dat");

            // Erstellt einen ObjectOutputStream, der mit dem FileOutputStream verbunden ist
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Serialisiert das String-Objekt "message" in die Datei
            objectOutputStream.writeObject(message);
            // hier benötigt weil dannach sofort ausgeschrieben wird
            objectOutputStream.flush();
            // Erstellt einen FileInputStream für die Datei "object.dat"
            FileInputStream fileInputStream = new FileInputStream("object.dat");

            // Erstellt einen ObjectInputStream, der mit dem FileInputStream verbunden ist
            objectInputStream = new ObjectInputStream(fileInputStream);

            // Deserialisiert das String-Objekt aus der Datei und castet es zu einem String
            String readMessage = (String) objectInputStream.readObject();

            // Gibt das deserialisierte String-Objekt auf der Konsole aus
            System.out.println("Objekt: " + readMessage);

        } catch (IOException e) {
            // Wird geworfen, wenn eine IOException auftritt
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Wird geworfen, wenn eine ClassNotFoundException auftritt
            System.err.println("Fehler beim Einlesen");
            e.printStackTrace();
        } finally {
            try {
                objectOutputStream.flush();
                // Schließt den ObjectOutputStream
                objectOutputStream.close();

                // Schließt den ObjectInputStream
                objectInputStream.close();
            } catch (IOException e) {
                // Wird ausgeführt, wenn eine IOException beim Schließen des Buffered-InputStreams auftritt
                e.printStackTrace();
            }
        }
    }
}

