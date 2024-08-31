package model;

import model.exceptions.ExpiredException;
import model.exceptions.MoneyException;
import model.exceptions.RicettaException;

import java.util.Date;

public class DaBanco extends AbstractMedicine{

    public DaBanco(String name, int basePrice, ExpirationDate expirationDate) {
        super(name, basePrice, expirationDate);
    }

    @Override
    public void buy(User user) throws MoneyException, ExpiredException, RicettaException {
        super.buy(user);
        user.setMoney(user.getMoney() - this.actualPrice);
    }

    @Override
    public void applyDiscount() {
        this.actualPrice = this.basePrice;
    }

    public String toString() {
        return super.toString() + "\n" + "Medicinale da banco";
    }
}
