package model.evocations;

import model.Energy;
import model.Player;
import model.attacks.AbstractAttack;
import model.exceptions.InsufficientEnergiesException;
import model.exceptions.WrongEnergyException;

public abstract class AbstractEvocation {
    private String name;
    private Energy type;
    private int totalLP;
    private int currentLP;
    private int energies;
    protected AbstractAttack attack;

    public AbstractEvocation(String name, Energy type, int totalLP, AbstractAttack attack) throws WrongEnergyException {
        this.name = name;
        this.type = type;
        this.totalLP = totalLP;
        this.currentLP = this.totalLP;
        this.energies = 0;
        this.attack = attack;
        attack.setOwner(this);
        if (!attack.getType().equals(this.type)) {
            throw new WrongEnergyException();
        }
    }

    public int getCurrentLP() {
        return currentLP;
    }

    public void setCurrentLP(int currentLP) {
        this.currentLP = currentLP;
    }

    public Energy getType() {
        return type;
    }

    public void addEnergy(Energy energy) throws WrongEnergyException {
        if (energy.equals(this.type)) {
            this.energies++;
        } else {
            throw new WrongEnergyException();
        }
    }

    public int getEnergies() {
        return energies;
    }

    public abstract void attack(Player opponent) throws InsufficientEnergiesException;


    public String toString() {
        return name + "\n" + currentLP + "/" + totalLP + " PV\n" + "Energie: " + energies + "\n" + attack.toString();
    }
}
