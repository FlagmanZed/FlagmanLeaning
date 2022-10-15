package HEStud;

import HEStud.Models.Student;
import HEStud.Models.University;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> universities =
                FileReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        for(University university : universities) {
            System.out.println(university);
        }

        List<Student> students =
                FileReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        for(Student student : students) {
            System.out.println(student);
        }
    }
}