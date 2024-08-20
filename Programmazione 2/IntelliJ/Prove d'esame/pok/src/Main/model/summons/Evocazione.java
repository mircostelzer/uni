package Main.model.summons;

import Main.model.energies.Energy;
import Main.model.exceptions.IncompatibleEnergyException;
import Main.model.exceptions.WrongEnergiesException;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public interface Evocazione {

    void attack(ArrayList<Evocazione> target) throws WrongEnergiesException;
    void applydamage(int d);
    Energy getEnergyType();
    ArrayList<Energy> getAllEnergies();
    boolean isdead();
    void assignEnergy(Energy e) throws IncompatibleEnergyException;

    Color getBorderColor();
    String getFirstLine();
    String getSecondLine();
    String getThirdLine();
    String getFourthLine();
}
