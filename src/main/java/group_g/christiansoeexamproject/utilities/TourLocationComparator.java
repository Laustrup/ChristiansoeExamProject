package group_g.christiansoeexamproject.utilities;

import group_g.christiansoeexamproject.models.TourLocation;

import java.io.Serializable;
import java.util.Comparator;

public class TourLocationComparator implements Comparator<TourLocation>, Serializable {
    @Override
    public int compare(TourLocation o1, TourLocation o2) {
        return o1.getStep() - o2.getStep();
    }


}
