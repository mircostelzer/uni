package model;

import model.exceptions.ExpiredException;
import model.exceptions.MoneyException;
import model.exceptions.RicettaException;

public interface Medicina {
    void buy(User user) throws MoneyException, ExpiredException, RicettaException;
    void applyDiscount();
    int getPrice();
    String getName();
    String toString();
}
