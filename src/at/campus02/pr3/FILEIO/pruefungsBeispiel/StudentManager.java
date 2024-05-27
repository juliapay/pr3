package at.campus02.pr3.FILEIO.pruefungsBeispiel;

import at.campus02.pr3.FILEIO.abschlussbeispiel.Address;
import at.campus02.pr3.FILEIO.abschlussbeispiel.AddressExportException;
import at.campus02.pr3.FILEIO.abschlussbeispiel.AddressExportFileAlreadyExistsException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
// todo - can be edited, if needed.
public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void add(Student student) {
        students.add(student);
    }
public  void   exportStudentsToBinaryFile(String pfad) throws StudentExportException {
String separator="%";
    File f = new File(pfad);
    System.out.println("File Path: " + f.getAbsolutePath());
    if (f.exists()) { // existiert das file? -> Exception
        throw new StudentExportException("file already exists");
    }
    //damit es ausserhalb des tryblocks geschlossen und geflushed wird
    FileWriter fw = null;
    BufferedWriter bw = null;

    try { // neues File öffnen
        fw = new FileWriter(f);
        bw = new BufferedWriter(fw);
        System.out.println("export: baue String zum exportieren zusammen...");
        for (Student student : students) {
            String one_line = student.getName() + separator +
                    student.getId() + separator +
                    student.getEmail() + separator;
            System.out.println("Eintrag: " + one_line); // auf die Konsole schreiben
            bw.write(one_line);
            bw.newLine();
            //in die Datei schreiben
        }
        bw.flush();
        bw.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @Override
    public String toString() {
        return "StudentManager{" +
                "students=" + students +
                '}';
    }


}
