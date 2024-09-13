package Main.model.summons.concrete;

import Main.model.energies.EnergyFuoco;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.summons.Attack;
import Main.model.summons.EvocazioneSuprema;

public class Phoenix extends EvocazioneSuprema {

    public Phoenix() throws IncompatibleEnergyException {
        super("Phoenix", 50, new EnergyFuoco(), new Attack("Fiammata", 2, new EnergyFuoco(), 20));
    }
}
