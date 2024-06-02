package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.example2;

public class Demo {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        studentManager.add(new Student("1", "John Doe", "Computer Science"));
        studentManager.add(new Student("2", "Jane Smith", "Mathematics"));
        studentManager.add(new Student("3", "Emily Davis", "Physics"));
        studentManager.add(new Student("4", "Michael Brown", "Biology"));
        studentManager.add(new Student("5", "Jessica Wilson", "Chemistry"));

        // Pfad zur Ausgabedatei
        String filePath = "students.dat";

        // Versuch, die Studentenliste in die Datei zu exportieren
        try {
            studentManager.exportStudentsToBinaryFile(filePath);
        } catch (StudentExportException e) {
            System.out.println(e.getMessage());
        }
    }
}
