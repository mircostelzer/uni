package model.power;

import model.interfaces.FanInterface;
import model.interfaces.MechanicalPowerInterface;

public class MechanicalPower implements MechanicalPowerInterface {

    @Override
    public String getPower() {
        return "Meccanica";
    }

    public double getMultiplier() {
        return 1;
    }
}
