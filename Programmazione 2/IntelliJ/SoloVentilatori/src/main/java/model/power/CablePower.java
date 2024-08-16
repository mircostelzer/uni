package model.power;

import model.interfaces.ElectricPowerInterface;

public class CablePower implements ElectricPowerInterface {

    @Override
    public String getPower() {
        return "Presa";
    }

    public int getMultiplier() {
        return 2;
    }
}
