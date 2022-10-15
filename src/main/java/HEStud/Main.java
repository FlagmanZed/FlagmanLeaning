package HEStud;

import HEStud.Comparators.StudComparator;
import HEStud.Comparators.UniverComparator;
import HEStud.Enums.StudEnum;
import HEStud.Enums.UniverEnum;
import HEStud.Models.Student;
import HEStud.Models.University;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> universities =
                FileReader.readUniver("src/main/resources/universityInfo.xlsx");
        UniverComparator univerComparator =
                Utilitarian.getUniversityComparator(UniverEnum.UNIVER_YEAR_OF_FOUNDATION);
        universities.stream()
                .sorted(univerComparator)
                .forEach(System.out::println);

        List<Student> students =
                FileReader.readStud("src/main/resources/universityInfo.xlsx");
        StudComparator studComparator =
                Utilitarian.getStudentComparator(StudEnum.STUD_AVG_EXAM_SCORE);
        students.stream()
                .sorted(studComparator)
                .forEach(System.out::println);
    }
}