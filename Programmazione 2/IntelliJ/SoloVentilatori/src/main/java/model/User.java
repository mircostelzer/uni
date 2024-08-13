package model;

import model.comparators.PriceComparator;
import model.comparators.TypeComparator;
import model.interfaces.FanInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
    private int capital;
    private int monthlyExpense;
    private List<FanInterface> subscription;
    private Comparator<FanInterface> comparator;

    public User() {
        this.capital = 100;
        this.monthlyExpense = 0;
        this.comparator = new TypeComparator();
        this.subscription = new ArrayList<>();
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public int getMonthlyExpense() {
        return monthlyExpense;
    }

    public void setMonthlyExpense(int monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public List<FanInterface> getSubscription() {
        return subscription;
    }

    public void addFan(FanInterface fan) {
        this.subscription.add(fan);
    }

    public void removeFan(FanInterface fan) {
        while (monthlyExpense > capital) {
            FanInterface toRemove = this.subscription.get(0);
            for (FanInterface f : subscription) {
                if (f.getPrice() > toRemove.getPrice()) {
                    toRemove = f;
                }
            }
            this.subscription.remove(toRemove);
        }
    }

    public void toggleComparator() {
        if (comparator instanceof TypeComparator) {
            comparator = new PriceComparator();
        } else {
            comparator = new TypeComparator();
        }
        this.sort();
    }

    private void sort() {
        subscription.sort(comparator);
    }

}
