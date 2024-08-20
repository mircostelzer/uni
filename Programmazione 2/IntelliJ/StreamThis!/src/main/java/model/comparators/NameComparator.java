package model.comparators;

import model.AbstractShow;

import java.util.Comparator;

public class NameComparator implements Comparator<AbstractShow> {
    @Override
    public int compare(AbstractShow o1, AbstractShow o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
