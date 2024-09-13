package model.power;

import model.interfaces.MechanicalPowerInterface;

public class MechanicalPower implements MechanicalPowerInterface {

    @Override
    public String getPower() {
        return "Meccanica";
    }

    public int getMultiplier() {
        return 1;
    }
}
