package model.evocations;

import model.Energy;
import model.Player;
import model.attacks.AbstractAttack;
import model.exceptions.InsufficientEnergiesException;
import model.exceptions.WrongEnergyException;

public class NormalEvocation extends AbstractEvocation {

    public NormalEvocation(String name, Energy type, int totalLP, AbstractAttack attack) throws WrongEnergyException {
        super(name, type, totalLP, attack);
    }

    @Override
    public void attack(Player opponent) throws InsufficientEnergiesException {
        this.attack.strike(opponent.getEvocations().get(0));
    }
}
