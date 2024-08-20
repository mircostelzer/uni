package Main.model.summons.concrete;

import Main.model.energies.EnergyFuoco;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.summons.Attack;
import Main.model.summons.EvocazioneBase;

public class Ifrit extends EvocazioneBase {

    public Ifrit() throws IncompatibleEnergyException {
        super("Ifrit", 30, new EnergyFuoco(), new Attack("Hellfire", 2, new EnergyFuoco(), 20));
    }
}
