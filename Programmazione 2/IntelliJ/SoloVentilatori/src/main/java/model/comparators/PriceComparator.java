package model.comparators;

import model.interfaces.FanInterface;

import java.util.Comparator;

public class PriceComparator implements Comparator<FanInterface> {
    @Override
    public int compare(FanInterface o1, FanInterface o2) {
        int p1 = o1.getPrice();
        int p2 = o2.getPrice();
        if (p1 == p2) {
            Comparator<FanInterface> comparator = new TypeComparator();
            return comparator.compare(o1, o2);
        } else {
            return p1 - p2;
        }
    }
}
