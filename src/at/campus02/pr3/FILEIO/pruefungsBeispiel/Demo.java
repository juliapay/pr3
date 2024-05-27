package at.campus02.pr3.FILEIO.pruefungsBeispiel;

// todo - can be edited, if needed.
public class Demo {

    public static void main(String[] args) {
        // todo: add your demo use case here.
        System.out.println("TEST");
        Student s1 = new Student("0101", "Pablo", "hot.stuff@mcDonalds.ie");
        Student s2 = new Student("0102", "Mia", "hoter.stuff@mcDonalds.ie");
        Student s3 = new Student("0103", "Mausi", "hotttest.stuff@mcDonalds.ie");
        Student s4 = new Student("0104", "Nemo", "Morehot.stuff@mcDonalds.ie");
        Student s5 = new Student("0105", "Gypsie", "MoreMorehot.stuff@mcDonalds.ie");

        String pfad = "C:\\Users\\Julia\\julia\\workingwoman\\SWENG C&M\\SWENG\\FH CAMPUS 02\\Seminare\\Programmieren 3\\pruefungsBeispiel\\studenten.dat";
        StudentManager studentManager = new StudentManager();
        studentManager.add(s1);
        studentManager.add(s2);
        studentManager.add(s3);
        studentManager.add(s4);
        studentManager.add(s5);

        try {
            studentManager.exportStudentsToBinaryFile(pfad);
        } catch (StudentExportException e) {
            throw new RuntimeException(e);
        }


    }

}
