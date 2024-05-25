package at.campus02.pr3.EXCEPTIONS.ObjekteInDateiSpeichernUndLesen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    public void add(Product p) {
        if (p != null) {
            productList.add(p);
        }
    }

    public void saveToFile(String path) {

        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            bufferedWriter = new BufferedWriter(printWriter);

            for (Product p : productList) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            // Wird ausgeführt, wenn die Datei nicht gefunden wird
            e.printStackTrace();
        } catch (IOException e) {
            // Wird ausgeführt, wenn eine IOException während des Schreibens der Datei auftritt
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
                System.out.println("Datei " + path + " erfolgreich geschrieben");
            } catch (IOException e) {

                System.out.println("Datei nicht gefunden");
                e.printStackTrace();
            }
        }
    }

    public void readFromFile(String path) {
        BufferedReader bufferedReader = null;

        try {
            // Erstellt ein FileReader-Objekt, um den Inhalt der Datei zu lesen
            FileReader fileReader = new FileReader(path);
            // Erstellt ein BufferedReader-Objekt, um den Inhalt der Datei Zeile für Zeile zu lesen
            bufferedReader = new BufferedReader(fileReader);
            // Liest den Inhalt der Datei Zeile für Zeile und gibt ihn in der Konsole aus
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Wird ausgeführt, wenn eine IOException während des Lesens der Datei auftritt
            e.printStackTrace();
        } finally {
            try {
                // Schließt das BufferedReader-Objekt, um Ressourcen freizugeben
                bufferedReader.close();
            } catch (IOException e) {
                // Wird ausgeführt, wenn eine IOException beim Schließen des BufferedReaders auftritt
                e.printStackTrace();
            }


        }
    }
}
