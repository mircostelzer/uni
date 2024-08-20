package Main.model.energies;

import Main.model.enums.EnergyTypes;
import javafx.scene.paint.Color;

public class EnergyNeutra extends AbstractEnergy{

    public EnergyNeutra() {
        super(EnergyTypes.Neutra);
    }

    public boolean isNegation(Energy e) {
        return false;
    }

    public boolean equals(Object o){
        if ( o == null ){
            return false;
        }
        return (o instanceof Energy);
    }

    public Color getColor() {
        return Color.HONEYDEW;
    }
}
