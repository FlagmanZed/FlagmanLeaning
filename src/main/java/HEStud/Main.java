package HEStud;

public class Main {

    public static void main(String[] args) {Student student = new Student();
        student.setFullName("Премудрова Елена Васильевна");
        student.setUniversityId("1");
        student.setCurrentCourseNumber(3);
        student.setAvgExamScore(4.9f);

        University univercity = new University();
        univercity.setId("1");
        univercity.setFullName("Московский Институт Иностранных Языков");
        univercity.setShortName("МИИЯ");
        univercity.setYearOfFoundation(1990);
        univercity.setMainProfile(StudyProfile.PHYSICALEDUCATION);

        System.out.println(student);
        System.out.println(univercity);
    }
}