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
        UniverComparator universityComparator =
                Utilitarian.getUniversityComparator(UniverEnum.UNIVER_YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Student> students =
                FileReader.readStud("src/main/resources/universityInfo.xlsx");
        StudComparator studentComparator =
                Utilitarian.getStudentComparator(StudEnum.STUD_AVG_EXAM_SCORE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            System.out.println(studentFromJson);
        });
    }
}