package model.power;

import model.interfaces.ElectricPowerInterface;
import model.interfaces.FanInterface;

public class CablePower implements ElectricPowerInterface {

    @Override
    public String getPower() {
        return "Presa";
    }

    public double getMultiplier() {
        return 2;
    }
}
