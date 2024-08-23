package model;

public class Geralt {
    private int level;
    private int gold;

    public Geralt(int level, int gold) {
        this.level = level;
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String toString() {
        return "Geralt" + "LV: " + level + ", GP: " + gold;
    }
}
