package HEStud.Comparators;

import HEStud.Models.University;
import org.apache.commons.lang3.StringUtils;

public class UniverID implements UniverComparator{

    @Override
    public int compare(University unv1, University unv2) {
        return StringUtils.compare(unv1.getId(), unv2.getId());
    }
}