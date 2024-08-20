package Main.model.summons.concrete;

import Main.model.energies.EnergyNeutra;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.summons.Attack;
import Main.model.summons.EvocazioneBase;

public class Alexander extends EvocazioneBase {

    public Alexander() throws IncompatibleEnergyException {
        super("Alexander", 30, new EnergyNeutra(), new Attack("Judgement", 1, new EnergyNeutra(), 10));

    }
}
