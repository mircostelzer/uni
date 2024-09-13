package model;

import model.exceptions.ExpiredException;
import model.exceptions.MoneyException;
import model.exceptions.RicettaException;

public class NonRipetibile extends ConRicetta{

    public NonRipetibile(String name, int basePrice, ExpirationDate expirationDate) {
        super(name, basePrice, expirationDate);
    }

    public void buy(User user) throws MoneyException, ExpiredException, RicettaException {
        super.buy(user);
        user.setMoney(user.getMoney() - this.actualPrice);
    }

    @Override
    public void applyDiscount() {
        this.actualPrice = this.basePrice - 10;
    }

    public String toString() {
        return super.toString() + "Non Ripetibile";
    }
}
