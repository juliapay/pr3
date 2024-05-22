package at.campus02.pr3.FILEIO.ObjekteInDateiSpeichernUndLesen;

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

        PrintWriter printWriter = new PrintWriter( new FileWriter(path));
        BufferedWriter bufferedWriter = new BufferedWriter(printWriter);

        for (Product p : productList) {
            bufferedWriter.write(p.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void readFromFile(String path) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println("Product Information successfully read.");
        bufferedReader.close();

    }
}
