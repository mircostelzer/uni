package model.fans;

import model.AbstractFan;
import model.interfaces.ElectricPowerInterface;

public class SoffittoFan extends AbstractFan {
    private ElectricPowerInterface electricPowerInterface;

    public SoffittoFan(String brand, ElectricPowerInterface electricPowerInterface) {
        super(brand);
        this.type = "Soffitto";
        this.electricPowerInterface = electricPowerInterface;
        this.power = this.electricPowerInterface.getPower();
        this.price = (AbstractFan.BASE_PRICE + 30) * this.electricPowerInterface.getMultiplier();
    }
}
