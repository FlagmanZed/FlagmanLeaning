package HEStud.Comparators;

import HEStud.Models.Student;

public class StudCurrentCourseNumber implements StudComparator{

    @Override
    public int compare(Student std1, Student std2) {
        return Integer.compare(std1.getCurrentCourseNumber(), std2.getCurrentCourseNumber());
    }
}