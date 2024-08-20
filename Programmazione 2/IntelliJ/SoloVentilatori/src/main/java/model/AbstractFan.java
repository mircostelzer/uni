package model;

import model.interfaces.FanInterface;

public abstract class AbstractFan implements FanInterface {
    protected String brand;
    protected int price;
    protected String type;
    protected String power;
    protected boolean isSubscribed;
    public static final int BASE_PRICE = 10;

    public AbstractFan(String brand) {
        this.brand = brand;
        this.isSubscribed = false;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public boolean getSubscription() {
        return isSubscribed;
    }

    public void setSubscription(boolean subscription) {
        isSubscribed = subscription;
    }

    public String toString() {
        return brand + '\n' +
                "Tipo: " + type + " Alimentazione: " + power + "\n" +
                "Costo: " + price;
    }
}
