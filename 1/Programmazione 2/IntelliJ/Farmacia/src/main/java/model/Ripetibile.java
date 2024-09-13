package model;

import model.exceptions.*;

public class Ripetibile extends ConRicetta{
    private int max;

    public Ripetibile(String name, int basePrice, ExpirationDate expirationDate, int max) {
        super(name, basePrice, expirationDate);
        this.max = max;
    }

    public void buy(User user) throws MoneyException, ExpiredException, RicettaException {
        super.buy(user);
        if (this.ricetta.getCounter() >= this.max) {
            throw new RipetibileException();
        }
        user.setMoney(user.getMoney() - this.actualPrice);
    }

    @Override
    public void applyDiscount() {
        this.actualPrice = this.basePrice - 5;
    }

    public String toString() {
        return super.toString() + "Ripetibile fino a " + this.max + " volte";
    }
}
