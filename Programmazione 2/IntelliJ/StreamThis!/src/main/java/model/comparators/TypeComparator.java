package model.comparators;

import model.shows.Anime;
import model.AbstractShow;
import model.shows.TVShow;

import java.util.Comparator;

public class TypeComparator implements Comparator<AbstractShow> {
    @Override
    public int compare(AbstractShow o1, AbstractShow o2) {
        int f1 = generateNumber(o1);
        int f2 = generateNumber(o2);
        if (f1 == f2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        return f1 - f2;
    }

    private int generateNumber(AbstractShow show) {
        if (show instanceof TVShow) {
            return 1;
        } else if (show instanceof Anime) {
            return 2;
        } else {
            return 3;
        }
    }
}
