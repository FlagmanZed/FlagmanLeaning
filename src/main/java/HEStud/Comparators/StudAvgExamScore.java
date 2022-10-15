package HEStud.Comparators;

import HEStud.Models.Student;

public class StudAvgExamScore implements StudComparator{

    @Override
    public int compare(Student std1, Student std2) {
        return Float.compare(std2.getAvgExamScore(), std1.getAvgExamScore());
    }
}