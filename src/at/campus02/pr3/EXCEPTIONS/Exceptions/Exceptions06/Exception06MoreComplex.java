package at.campus02.pr3.EXCEPTIONS.Exceptions.Exceptions06;

import java.io.*;
import java.util.Arrays;

public class Exception06MoreComplex {
    public static class myClass implements Serializable{
        int a = 5;
        byte[] c = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        double d=7.22;
        String b="Hallo ich bin ein String in der Klasse";

        @Override
        public String toString() {
            return "myClass{" +
                    "a=" + a +
                    ", c=" + Arrays.toString(c) +
                    ", d=" + d +
                    ", b='" + b + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        //String message = "Hallo Welt";
        myClass myObject=new myClass();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            // Erstellt einen FileOutputStream für die Datei "object.dat"
            FileOutputStream fileOutputStream = new FileOutputStream("object.dat");

            // Erstellt einen ObjectOutputStream, der mit dem FileOutputStream verbunden ist
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Serialisiert das String-Objekt "message" in die Datei
            objectOutputStream.writeObject(myObject);
            // hier benötigt weil dannach sofort ausgeschrieben wird
            objectOutputStream.flush();
            // Erstellt einen FileInputStream für die Datei "object.dat"
            FileInputStream fileInputStream = new FileInputStream("object.dat");

            // Erstellt einen ObjectInputStream, der mit dem FileInputStream verbunden ist
            objectInputStream = new ObjectInputStream(fileInputStream);

            // Deserialisiert das String-Objekt aus der Datei und castet es zu einem String
            myClass eingeleseneKlasse = (myClass) objectInputStream.readObject();

            // Gibt das deserialisierte String-Objekt auf der Konsole aus
            System.out.println("Objekt: " + eingeleseneKlasse);

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

