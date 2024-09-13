package model;

import model.exceptions.*;

import java.util.Date;

public abstract class ConRicetta extends AbstractMedicine {
    protected Ricetta ricetta;

    public ConRicetta(String name, int basePrice, ExpirationDate expirationDate) {
        super(name, basePrice, expirationDate);
    }

    public void buy(User user) throws MoneyException, ExpiredException, RicettaException {
        super.buy(user);
        if (!user.hasRicetta(this.ricetta)) {
            throw new RicettaMancanteException();
        }
        if (!this.hasRicetta()) {
            throw new RicettaNonSelezionata();
        }
        this.ricetta.useRicetta();
    }

    public void setRicetta(Ricetta ricetta) {
        this.ricetta = ricetta;
    }

    public boolean hasRicetta() {
        return ricetta.isSelected();
    }

    public String toString() {
        return super.toString() + "\nCon ricetta: ";
    }
}
