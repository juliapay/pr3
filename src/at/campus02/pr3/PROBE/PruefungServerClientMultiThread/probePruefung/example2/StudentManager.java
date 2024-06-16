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

    // Methode zum Exportieren der Studentenliste in eine Binärdatei
    public void exportStudentsToBinaryFile(String dateipfad) throws StudentExportException {
        // Erstellen eines File-Objekts mit dem angegebenen Pfad
        File file = new File(dateipfad);
        System.out.println("File Path: " + file.getAbsolutePath());

        // Überprüfen, ob die Datei bereits existiert
        if (file.exists()) {
            throw new StudentExportException("Datei existiert bereits!");
        }

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            // Öffnen einer neuen Datei zum Schreiben
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            System.out.println("exportToCsv: baue String zum exportieren zusammen...");

            // Durchlaufen der Studentenliste und Schreiben der Daten in die Datei
            for (Student student : students) {
                String one_line = student.getName() + " / " +
                        student.getId() + " / " +
                        student.getEmail();
                System.out.println("Eintrag: " + one_line); // Ausgabe des Eintrags auf die Konsole
                bw.write(one_line); // Schreiben des Eintrags in die Datei
                bw.newLine(); // Neue Zeile in die Datei schreiben
            }

            bw.flush(); // Sicherstellen, dass alle Daten geschrieben werden
            bw.close(); // Schließen des BufferedWriter
        } catch (IOException e) {
            // Fehlerbehandlung bei IO-Exceptions und Werfen einer benutzerdefinierten Ausnahme
            throw new StudentExportException(e.getMessage());
        }
    }
}