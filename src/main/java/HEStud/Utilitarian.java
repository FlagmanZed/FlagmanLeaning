package HEStud;

import HEStud.Comparators.*;
import HEStud.Enums.StudEnum;
import HEStud.Enums.UniverEnum;

public class Utilitarian {

    private Utilitarian() {
    }

    public static StudComparator getStudentComparator(StudEnum studEnum) {

        switch (studEnum) {

            case STUD_UNIVERSITY_ID:
                return new StudUniversityID();
            case STUD_FULL_NAME:
                return new StudFullName();
            case STUD_CURRENT_COURSE_NUMBER:
                return new StudCurrentCourseNumber();
            case STUD_AVG_EXAM_SCORE:
                return new StudAvgExamScore();
            default:
                return new StudFullName();
        }
    }

    public static UniverComparator getUniversityComparator(UniverEnum univerEnum) {

        switch (univerEnum) {

            case UNIVER_ID:
                return new UniverID();
            case UNIVER_FULL_NAME:
                return new UniverFullName();
            case UNIVER_SHORT_NAME:
                return new UniverShortName();
            case UNIVER_MAIN_PROFILE:
                return new UniverMainProfile();
            case UNIVER_YEAR_OF_FOUNDATION:
                return new UniverYearOfFoundation();
            default:
                return new UniverFullName();
        }
    }
}