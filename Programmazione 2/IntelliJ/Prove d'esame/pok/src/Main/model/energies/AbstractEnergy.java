package Main.model.energies;

import Main.model.enums.EnergyTypes;

public abstract class AbstractEnergy implements Energy{
    protected EnergyTypes type;

    protected AbstractEnergy(EnergyTypes e){
        this.type = e;
    }

    public EnergyTypes getType(){
        return this.type;
    }

    public boolean equals(Object o){
        if ( o == null ){
            return false;
        }
        if (! (o instanceof Energy) ){
            return false;
        }
        if (o instanceof EnergyNeutra){
            return true;
        }
        return this.type == ((Energy) o).getType();
    }
}
