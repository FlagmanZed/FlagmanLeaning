package HEStud.Comparators;

import HEStud.Models.University;
import org.apache.commons.lang3.StringUtils;

public class UniverMainProfile implements UniverComparator{

    @Override
    public int compare(University unv1, University unv2) {
        if (null == unv1.getMainProfile()) {
            return 1;
        } else if (null == unv2.getMainProfile()) {
            return -1;
        }
        return StringUtils.compare(unv1.getMainProfile().name(), unv2.getMainProfile().name());
    }
}