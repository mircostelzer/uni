package model.attacks;

import model.evocations.AbstractEvocation;
import model.Energy;
import model.exceptions.InsufficientEnergiesException;

public class FireAttack extends AbstractAttack {

    public FireAttack(String name, int damage, int neededEnergies) {
        super(Energy.Fire, name, damage, neededEnergies);
    }
    @Override
    public void strike(AbstractEvocation evocation) throws InsufficientEnergiesException {
        if (owner.getEnergies() < this.neededEnergies) {
            throw new InsufficientEnergiesException();
        } else if (evocation.getType().equals(Energy.Water)) {
            evocation.setCurrentLP(evocation.getCurrentLP() - (this.damage*2));
        } else {
            evocation.setCurrentLP(evocation.getCurrentLP() - this.damage);
        }
    }
}
