package model.interfaces;

public interface FanInterface {
    String getBrand();
    int getPrice();
    void setPrice(int price);
    void setPower(String power);
    boolean getSubscription();
    void setSubscription(boolean subscription);
    String toString();
}
