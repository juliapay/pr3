package at.campus02.pr3.FILEIO.Uebung11;

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

    public void saveToFile(String path) throws IOException {

        // Erstellt einen FileWriter
        FileWriter fileWriter = new FileWriter(path);
        // Erstellt einen PrintWriter, der mit dem FileWriter verbunden ist
        PrintWriter printWriter = new PrintWriter(fileWriter);
        BufferedWriter bufferedWriter = new BufferedWriter(printWriter);

        for (Product p : productList) {
            bufferedWriter.write(p.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        // Schließt den PrintWriter, um die Datei zu schließen
        bufferedWriter.close();
    }

    public void readFromFile(String path) throws IOException {

        // Erstellt ein FileReader-Objekt, um den Inhalt der Datei zu lesen
        FileReader fileReader = new FileReader(path);
        // Erstellt ein BufferedReader-Objekt, um den Inhalt der Datei Zeile für Zeile zu lesen
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // Liest den Inhalt der Datei Zeile für Zeile und gibt ihn in der Konsole aus
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // Schließt das BufferedReader-Objekt, um Ressourcen freizugeben
        bufferedReader.close();

    }
}
