package Main.model.energies;

import Main.model.enums.EnergyTypes;
import javafx.scene.paint.Color;

public interface Energy{
    EnergyTypes getType();
    boolean isNegation(Energy e);

    Color getColor();
}
