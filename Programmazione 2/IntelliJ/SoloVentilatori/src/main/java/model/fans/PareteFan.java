package model.fans;

import model.AbstractFan;
import model.interfaces.PowerInterface;

public class PareteFan extends AbstractFan {
    private PowerInterface powerInterface;

    public PareteFan(String brand, PowerInterface powerInterface) {
        super(brand);
        this.type = "Parete";
        this.powerInterface = powerInterface;
        this.power = this.powerInterface.getPower();
        this.price = (AbstractFan.BASE_PRICE + 20) * this.powerInterface.getMultiplier();
    }
}
