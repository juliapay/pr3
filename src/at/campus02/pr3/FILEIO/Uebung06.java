package at.campus02.pr3.FILEIO;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Uebung06 {
    //    Goal: Create 10 Files + Rename all files (only files) of the given directory (not for subdirectories)
//
//            1. Write a method, which creates 10 files, in a given directory (= Method Parameter) and with a random file name/number (Tip: concatenate for final filepath)
//2. Write a method, which renames all files (only files and not directories!) within a given folder (= Method Parameter)
//            2.1 for example: test.txt to 1_test.txt
//2.1.1 for the new file name - concatenate a string with .getParent(), separator + pre_id + getName()
//2.1.2 use renameTo() method
//2.1.3 Check if the rename was a success (via if) and print the according message to the console
//3. Write a method, which deletes all files within this directory. (Comment out this or other methods to test it..)
//
//    Tip: Random Number:
//            ThreadLocalRandom.current().nextInt()
    public static void main(String[] args) throws IOException {
        String directory = "C:\\campus02\\test\\demo4";
        createRandomFiles(directory, 10);
        renameAllFiles(directory);
        deleteAllFiles(directory);
    }

    public static void createRandomFiles(String directory, int numberOfFiles) throws IOException {
        File dir = new File(directory);
        Random random = new Random();


        for (int i = 0; i < numberOfFiles; i++) {
            String randomName = "random_" + Math.abs(random.nextInt()) + ".txt";
            File file = new File(dir, randomName);
            file.createNewFile();
            System.out.println(file.getName());
        }
    }


    public static void renameAllFiles(String directory) {
//        hier fehlt der übergabe parameter (File basedir)
//          String preID="8_";
//          for(File oneFile: dir.listFiles()) {
//            System.out.println("Renaming: " + oneFile.getName());
//
//            String newName = baseDir.getAbsolutePath()+
//            File.separator+preID+oneFile.getName();
//            File file1=new File(newName);
//            oneFile.renameTo(file1);
//        }
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String renameName = "1" + "_" + file.getName();
                        File newFile = new File(file.getParent(), renameName);
                        boolean success=file.renameTo(newFile);
                        if (success) {
                            System.out.println("File renamed: " + file.getName() + " to " + newFile.getName()+" "+success);

                        }
                    }
                }
            }
        }

    }
    public static void deleteAllFiles(String directory) {
//                          (File baseDir) UEBERGABEPARAMETER
//      for (File oneFile:baseDir.listFiles){
//          if(file.exists()&&file.isFile()){
//              file.delete();
//        }}
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            // assert files!=null;  MOEGLICHKEIT DEI IF BEDINGUNG ABZUFANGEN
            if (files != null) {
                for (File file : files) {
                    if (file.exists()&&file.isFile()) {
                        String name=file.getName();
                        boolean success=file.delete();

                            System.out.println("File deleted: " + name+" "+success);
                    }
                }
            }
        }

    }
}

