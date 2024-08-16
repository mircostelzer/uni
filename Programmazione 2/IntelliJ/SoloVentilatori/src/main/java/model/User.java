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
    private int months;
    private List<FanInterface> subscription;

    public User() {
        this.capital = 100;
        this.monthlyExpense = 0;
        this.months = 0;
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

    public void addFan(FanInterface fan) {
        fan.setSubscription(true);
        subscription.add(fan);
    }

    public void removeFan() {
        while(monthlyExpense > capital) {
            FanInterface toRemove = subscription.get(0);
            for(FanInterface fan : subscription) {
                if (fan.getPrice() > toRemove.getPrice()) {
                    toRemove = fan;
                }
            }
            subscription.remove(toRemove);
            monthlyExpense -= toRemove.getPrice();
            toRemove.setSubscription(false);
        }
    }

    public void setMonthlyExpense(int monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public void advanceMonth() throws BrokeException {
        this.months++;
        if (monthlyExpense > capital) {
            this.removeFan();
            throw new BrokeException();
        }
        capital -= monthlyExpense;
        monthlyExpense = 0;
        for (FanInterface fan : subscription) {
            if (fan.getSubscription()) {
                monthlyExpense += fan.getPrice();
            }
        }
    }

    public String toString() {
        return "Capitale: " + capital + " Spesa Mensile: " + monthlyExpense + " Mesi Trascorsi: " + months;
    }

    public boolean canPurchase(FanInterface fan) {
        return capital >= fan.getPrice();
    }

}
