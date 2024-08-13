package model;

import model.interfaces.FanInterface;

public abstract class AbstractFan implements FanInterface {
    protected String brand;
    protected int price;
    protected String type;
    protected String power;
    protected boolean isSubscribed;
    public static final double BASE_PRICE = 10;

    public AbstractFan(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }
}
