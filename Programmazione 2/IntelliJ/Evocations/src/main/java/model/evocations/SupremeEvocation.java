package model.evocations;

import model.Energy;
import model.Player;
import model.attacks.AbstractAttack;
import model.exceptions.InsufficientEnergiesException;
import model.exceptions.WrongEnergyException;

import java.util.List;

public class SupremeEvocation extends AbstractEvocation {

    public SupremeEvocation(String name, Energy type, int totalLP, AbstractAttack attack) throws WrongEnergyException {
        super(name, type, totalLP, attack);
    }

    @Override
    public void attack(Player opponent) throws InsufficientEnergiesException {
        List<AbstractEvocation> toAttack = opponent.getEvocations();
        for (AbstractEvocation e : toAttack) {
            this.attack.strike(e);
        }
    }
}
