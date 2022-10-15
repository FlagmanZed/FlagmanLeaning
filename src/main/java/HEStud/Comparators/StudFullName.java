package HEStud.Comparators;

import HEStud.Models.Student;
import org.apache.commons.lang3.StringUtils;

public class StudFullName implements StudComparator {

    @Override
    public int compare(Student std1, Student std2) {
        return StringUtils.compare(std1.getFullName(), std2.getFullName());
    }
}