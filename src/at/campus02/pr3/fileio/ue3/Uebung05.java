package at.campus02.pr3.fileio.ue3;

import java.io.File;

public class Uebung05 {
    //    Tip: use mkdirs()
//    Write a method, which creates multiple directories. Example: "C:\\campus02\\test\\demo4" (Campus, Test, Demo4 will be created)
//            - It should also be checked, if the given directory has been created -> print it to the console:
//            -> IF Yes: Directory C:\campus02\test\demo4 created?: true
//            -> IF No: Directory C:\campus02\test\demo4 created?: false
//
//    Question: What is the difference between mkdirs() and mkdir() ?
//    Question: What does mkdirs() return?
//    Question: What does mkdir() return?
    public static void main(String[] args) {
        String directory = new String("C:\\campus02\\test\\demo4");

        System.out.println(createDirectory(directory));
    }

    public static boolean createDirectory(String directory) {

        File dir = new File(directory);
        dir.mkdirs();
        if (!dir.exists()) {
            return false;
        }
        System.out.println(dir.getPath() + ": True");
        return true;
    }


}




