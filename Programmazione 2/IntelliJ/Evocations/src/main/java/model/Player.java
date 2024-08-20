package model;

import model.evocations.AbstractEvocation;
import model.exceptions.InsufficientEnergiesException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<AbstractEvocation> evocations;
    private List<Energy> energies;

    public Player() {
        this.evocations = new ArrayList<>();
        this.energies = new ArrayList<>();
    }

    public void addEvocation(AbstractEvocation evocation) {
        this.evocations.add(evocation);
    }

    public void addEnergy(Energy energy) {
        this.energies.add(energy);
    }

    public List<AbstractEvocation> getEvocations() {
        return evocations;
    }

    public void attack(Player opponent) throws InsufficientEnergiesException {
        this.evocations.get(0).attack(opponent);
    }

    public boolean hasLost() {
        return evocations.isEmpty();
    }
}
