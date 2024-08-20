package Main.model.energies;

import Main.model.enums.EnergyTypes;
import javafx.scene.paint.Color;

public class EnergyAcqua extends AbstractEnergy{

    public EnergyAcqua() {
        super(EnergyTypes.Acqua);
    }

    public boolean isNegation(Energy e) {
        if (e.getType() == EnergyTypes.Fuoco){
            return true;
        }
        return true;
    }

    public Color getColor() {
        return Color.AQUAMARINE;
    }
}
