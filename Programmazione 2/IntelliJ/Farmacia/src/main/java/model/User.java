package model;

import model.exceptions.MoneyException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int money;
    private Date date;
    private List<Ricetta> ricette;

    public User(int money) {
        this.money = money;
        this.date = new Date();
        this.ricette = new ArrayList<>();
    }

    public boolean hasRicetta(Ricetta ricetta) {
        return this.ricette.contains(ricetta);
    }

    public List<Ricetta> getRicette() {
        return ricette;
    }

    public boolean canBuy(Medicina medicina) {
        return medicina.getPrice() <= money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String toString() {
        return "$ totali: " + money + "  " + date.toString();
    }
}
