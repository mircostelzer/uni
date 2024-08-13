package model.comparators;

import model.fans.PareteFan;
import model.fans.PiantanaFan;
import model.interfaces.FanInterface;

import java.util.Comparator;

public class TypeComparator implements Comparator<FanInterface> {
    @Override
    public int compare(FanInterface o1, FanInterface o2) {
        int n1 = generateNum(o1);
        int n2 = generateNum(o2);
        if (n1 == n2) {
            return o1.getPrice() - o2.getPrice();
        } else {
            return n1 - n2;
        }
    }

    private int generateNum(FanInterface f) {
        if (f instanceof PiantanaFan) {
            return 1;
        } else if (f instanceof PareteFan) {
            return 2;
        } else {
            return 3;
        }
    }
}
