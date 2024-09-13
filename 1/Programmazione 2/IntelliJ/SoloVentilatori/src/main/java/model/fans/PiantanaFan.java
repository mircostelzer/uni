package model.fans;

import model.AbstractFan;
import model.interfaces.PowerInterface;

public class PiantanaFan extends AbstractFan {
    private PowerInterface powerInterface;

    public PiantanaFan(String brand, PowerInterface powerInterface) {
        super(brand);
        this.type = "Piantana";
        this.powerInterface = powerInterface;
        this.power = this.powerInterface.getPower();
        this.price = (AbstractFan.BASE_PRICE + 10) * this.powerInterface.getMultiplier();
    }

}
