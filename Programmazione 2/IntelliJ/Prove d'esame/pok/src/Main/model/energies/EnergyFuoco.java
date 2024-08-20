package Main.model.energies;

import Main.model.enums.EnergyTypes;
import javafx.scene.paint.Color;

public class EnergyFuoco extends AbstractEnergy{

    public EnergyFuoco() {
        super(EnergyTypes.Fuoco);
    }

    public boolean isNegation(Energy e) {
        if (e.getType() == EnergyTypes.Acqua){
            return true;
        }
        return false;
    }

    public Color getColor() {
        return Color.FIREBRICK;
    }
}
