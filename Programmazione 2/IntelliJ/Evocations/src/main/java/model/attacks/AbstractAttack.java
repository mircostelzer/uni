package model.attacks;

import model.evocations.AbstractEvocation;
import model.Energy;
import model.exceptions.InsufficientEnergiesException;

public abstract class AbstractAttack {
    private Energy type;
    private String name;
    protected int damage;
    protected int neededEnergies;
    protected AbstractEvocation owner;


    public AbstractAttack(Energy type, String name, int damage, int neededEnergies, AbstractEvocation owner) {
        this.type = type;
        this.name = name;
        this.damage = damage;
        this.neededEnergies = neededEnergies;
        this.owner = owner;
    }

    public String toString() {
        return name + " (" + neededEnergies + ")\n" + damage + " danni";
    }

    public Energy getType() {
        return type;
    }

    public abstract void strike(AbstractEvocation evocation) throws InsufficientEnergiesException;
}
