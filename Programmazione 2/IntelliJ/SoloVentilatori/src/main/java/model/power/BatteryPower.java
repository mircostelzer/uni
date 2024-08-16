package model.power;

import model.interfaces.ElectricPowerInterface;

public class BatteryPower implements ElectricPowerInterface {

    @Override
    public String getPower() {
        return "Batteria";
    }

    public int getMultiplier() {
        return 3;
    }
}
