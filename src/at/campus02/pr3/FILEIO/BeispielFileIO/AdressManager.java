package at.campus02.pr3.FILEIO.BeispielFileIO;

import at.campus02.pr3.FILEIO.Exceptions.Exceptions06.Exception06MoreComplex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdressManager {
    private List<Address> addresses;

    public AdressManager(List<Address> addresses) {
        this.addresses = new ArrayList<>();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void add(Address a) {
        if (addresses != null) {
            add(a);
        }
    }

    public void exportToCsv(String path, String seperator) {

        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        File file = new File(path);
        if (file.exists()) {

        }
        try {
            // Erstellt einen FileOutputStream für die Datei "object.dat"
            FileOutputStream fileOutputStream = new FileOutputStream(path);


            // Erstellt einen ObjectOutputStream, der mit dem FileOutputStream verbunden ist
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Address a : addresses) {
                objectOutputStream.writeObject(a.getFirstname()+seperator+a.getLastname()+seperator+a.getMobilNumber()+seperator+a.getEmail());

            }

            // hier benötigt weil dannach sofort ausgeschrieben wird
            objectOutputStream.flush();
            // Erstellt einen FileInputStream für die Datei "object.dat"
            FileInputStream fileInputStream = new FileInputStream("object.dat");

            // Erstellt einen ObjectInputStream, der mit dem FileInputStream verbunden ist
            objectInputStream = new ObjectInputStream(fileInputStream);

            // Deserialisiert das String-Objekt aus der Datei und castet es zu einem String
            Exception06MoreComplex.myClass eingeleseneKlasse = (Exception06MoreComplex.myClass) objectInputStream.readObject();

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
