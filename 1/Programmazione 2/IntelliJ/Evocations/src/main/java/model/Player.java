package model;

import model.evocations.AbstractEvocation;
import model.exceptions.InsufficientEnergiesException;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String id;
    private List<AbstractEvocation> evocations;
    private List<Energy> energies;

    public Player(String id) {
        this.id = id;
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

    public List<Energy> getEnergies() {
        return energies;
    }

    public void removeEvocation() {
        evocations.removeIf(evocation -> evocation.getCurrentLP() <= 0);
    }

    public void attack(Player opponent, AbstractEvocation evocation) throws InsufficientEnergiesException {
        evocation.attack(opponent);
        opponent.removeEvocation();
    }

    public boolean hasLost() {
        return evocations.isEmpty();
    }
}
