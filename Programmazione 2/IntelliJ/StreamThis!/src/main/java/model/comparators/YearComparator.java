package model.comparators;

import model.AbstractShow;

import java.util.Comparator;

public class YearComparator implements Comparator<AbstractShow> {
    @Override
    public int compare(AbstractShow o1, AbstractShow o2) {
        if (o1.getYear() == o2.getYear()) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
        else {
            return o1.getYear() - o2.getYear();
        }
    }
}
