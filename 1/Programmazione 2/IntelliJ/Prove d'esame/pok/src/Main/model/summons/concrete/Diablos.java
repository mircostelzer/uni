package Main.model.summons.concrete;

import Main.model.energies.EnergyTenebra;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.summons.Attack;
import Main.model.summons.EvocazioneBase;

public class Diablos extends EvocazioneBase {

    public Diablos() throws IncompatibleEnergyException {
        super("Diablos", 50, new EnergyTenebra(), new Attack("Demi", 1, new EnergyTenebra(), 20));
    }
}
