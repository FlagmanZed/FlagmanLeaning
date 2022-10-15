package HEStud.Comparators;

import HEStud.Models.University;

public class UniverYearOfFoundation implements UniverComparator{

    @Override
    public int compare(University unv1, University unv2) {
        return Integer.compare(unv1.getYearOfFoundation(), unv2.getYearOfFoundation());
    }
}