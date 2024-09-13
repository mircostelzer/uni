package Main.model.summons.concrete;

import Main.model.energies.EnergyAcqua;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.summons.Attack;
import Main.model.summons.EvocazioneBase;

public class Leviathan extends EvocazioneBase {

    public Leviathan() throws IncompatibleEnergyException {
        super("Leviathan", 30, new EnergyAcqua(), new Attack("Tsunami", 1, new EnergyAcqua(), 10));

    }
}
