package model.attacks;

import model.evocations.AbstractEvocation;
import model.Energy;
import model.exceptions.InsufficientEnergiesException;

public class WaterAttack extends AbstractAttack {

    public WaterAttack(String name, int damage, int neededEnergies) {
        super(Energy.Water, name, damage, neededEnergies);
    }
    @Override
    public void strike(AbstractEvocation evocation) throws InsufficientEnergiesException {
        if (owner.getEnergies() < this.neededEnergies) {
            throw new InsufficientEnergiesException();
        } else if (evocation.getType().equals(Energy.Fire)) {
            evocation.setCurrentLP(evocation.getCurrentLP() - (this.damage*2));
        } else {
            evocation.setCurrentLP(evocation.getCurrentLP() - this.damage);
        }
    }
}
