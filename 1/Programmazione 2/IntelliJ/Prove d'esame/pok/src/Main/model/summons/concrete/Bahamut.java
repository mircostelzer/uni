package Main.model.summons.concrete;

import Main.model.energies.EnergyNeutra;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.summons.Attack;
import Main.model.summons.EvocazioneSuprema;

public class Bahamut extends EvocazioneSuprema {

    public Bahamut() throws IncompatibleEnergyException {
        super("Bahamut", 60, new EnergyNeutra(), new Attack("Mega Flare", 3, new EnergyNeutra(), 40));
    }
}
