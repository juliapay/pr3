package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.example2;

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

    @Override
    public String toString() {
        return "StudentManager{" +
                "students=" + students +
                '}';
    }

    public void exportStudentsToBinaryFile(String dateipfad) throws StudentExportException {
        File file = new File(dateipfad);
        System.out.println("File Path: " + file.getAbsolutePath());

        if (file.exists()) {
            throw new StudentExportException("Datei existiert bereits!");
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        try { // neues File öffnen
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            System.out.println("exportToCsv: baue String zum exportieren zusammen...");
            for (Student student : students) {
                String one_line = student.getName() + " / " +
                        student.getId() + " / " +
                        student.getEmail();
                System.out.println("Eintrag: " + one_line); // auf die Konsole schreiben
                bw.write(one_line);
                bw.newLine();
                //in die Datei schreiben
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new StudentExportException(e.getMessage());
        }
    }
}
