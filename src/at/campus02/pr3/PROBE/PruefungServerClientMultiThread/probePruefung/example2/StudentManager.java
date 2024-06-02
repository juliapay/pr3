package at.campus02.pr3.PROBE.PruefungServerClientMultiThread.probePruefung.example2;

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

    public void exportStudentsToBinaryFile () {
        // todo - add your code here
    }
}
