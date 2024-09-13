package model.attacks;

import model.evocations.AbstractEvocation;
import model.Energy;
import model.exceptions.InsufficientEnergiesException;

public class NeutralAttack extends AbstractAttack {

    public NeutralAttack(String name, int damage, int neededEnergies) {
        super(Energy.Neutral, name, damage, neededEnergies);
    }
    @Override
    public void strike(AbstractEvocation evocation) throws InsufficientEnergiesException {
        if (owner.getEnergies() < this.neededEnergies) {
            throw new InsufficientEnergiesException();
        } else {
            evocation.setCurrentLP(evocation.getCurrentLP() - this.damage);
    }
    }
}
