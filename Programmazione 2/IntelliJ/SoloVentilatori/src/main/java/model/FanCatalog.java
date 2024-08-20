package model;

import model.comparators.PriceComparator;
import model.comparators.TypeComparator;
import model.fans.PareteFan;
import model.fans.PiantanaFan;
import model.fans.SoffittoFan;
import model.interfaces.FanInterface;
import model.power.BatteryPower;
import model.power.CablePower;
import model.power.MechanicalPower;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FanCatalog {
    private List<AbstractFan> fans;
    private Comparator<AbstractFan> comparator;

    public FanCatalog() {
        this.fans = new ArrayList<>();
        this.comparator = new TypeComparator();
        fans.add(new PiantanaFan("Ariete", new BatteryPower()));
        fans.add(new PareteFan("Bosch", new CablePower()));
        fans.add(new PareteFan("Bosch", new MechanicalPower()));
        fans.add(new SoffittoFan("Bosch", new BatteryPower()));
        fans.add(new SoffittoFan("Parkside", new CablePower()));
        this.sort();
    }

    public List<AbstractFan> getFans() {
        return fans;
    }

    public void toggleComparator(Comparator<AbstractFan> comparator) {
        this.comparator = comparator;
        this.sort();
    }

    private void sort() {
        fans.sort(comparator);
    }
}
