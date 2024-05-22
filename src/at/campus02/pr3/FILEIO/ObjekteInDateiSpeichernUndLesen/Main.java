package at.campus02.pr3.FILEIO.ObjekteInDateiSpeichernUndLesen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ProductManager productManager = new ProductManager();

        Product p1= new Product("p1",10,"01");
        Product p2= new Product("p2",20,"02");
        Product p3= new Product("p3",30,"01");

        productManager.add(p1);
        productManager.add(p2);
        productManager.add(p3);

        productManager.saveToFile("C:\\campus02\\test\\uebung11.txt");
        productManager.readFromFile("C:\\campus02\\test\\uebung11.txt");

    }
}
