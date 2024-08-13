package model.power;

import model.interfaces.ElectricPowerInterface;
import model.interfaces.FanInterface;

public class BatteryPower implements ElectricPowerInterface {

    @Override
    public String getPower() {
        return "Batteria";
    }

    public double getMultiplier() {
        return 3;
    }
}
