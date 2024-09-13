package Main.model.energies;

import Main.model.enums.EnergyTypes;
import javafx.scene.paint.Color;

public class EnergyTenebra extends AbstractEnergy{

    public EnergyTenebra() {
        super(EnergyTypes.Tenebra);
    }

    public boolean isNegation(Energy e) {
        return true;
    }

    public Color getColor() {
        return Color.DARKVIOLET;
    }
}
