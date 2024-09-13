package model;

import model.exceptions.ExpiredException;
import model.exceptions.MoneyException;
import model.exceptions.RicettaException;

import java.util.Date;

public abstract class AbstractMedicine implements Medicina{
    private String name;
    protected int basePrice;
    protected int actualPrice;
    private ExpirationDate expirationDate;

    public AbstractMedicine(String name, int basePrice, ExpirationDate expirationDate) {
        this.name = name;
        this.basePrice = basePrice;
        this.expirationDate = expirationDate;
        this.applyDiscount();
    }

    public String getName() {
        return name;
    }


    public int getPrice() {
        return actualPrice;
    }

    public void buy(User user) throws MoneyException, ExpiredException, RicettaException {
        if (expirationDate.isExpired()) {
            throw new ExpiredException();
        }
        if (!user.canBuy(this)) {
            throw new MoneyException();
        }
    }



    public String toString() {
        return name + "\n"
                + "Costo base: " + basePrice + "$, Scontato a " + actualPrice + "$\n"
                + "Scadenza: " + expirationDate.toString();
    }
}
