package Main.view;

import Main.model.energies.Energy;
import javafx.scene.shape.Rectangle;

public class EnergyPane extends Rectangle {

    private Energy energy;
    private int index;

    public EnergyPane(Energy e, int i){
        super(70,30);
        this.energy = e;
        this.index = i;
        this.setFill(e.getColor());
    }

    public int getEnergia() {
        return this.index;
    }
}
