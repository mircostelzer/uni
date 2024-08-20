package Main.model.summons;

import Main.model.energies.Energy;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.exceptions.WrongEnergiesException;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class EvocazioneSuprema extends EvocazioneBase{

    public EvocazioneSuprema(String n, int p, Energy t, Attack a) throws IncompatibleEnergyException {
        super(n, p, t, a);
    }

    @Override
    public void attack(ArrayList<Evocazione> target) throws WrongEnergiesException {
        for (Evocazione t: target) {
            super.attack(t);
        }
    }

    @Override
    public Color getBorderColor() {
        return Color.BLACK;
    }
    @Override
    protected String getTargets(){
        return "(all)";
    }
}
