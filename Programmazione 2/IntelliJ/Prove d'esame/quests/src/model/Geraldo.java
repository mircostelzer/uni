package model;

public class Geraldo {

    private int level;
    private int cash;

    public Geraldo(){
        this.cash = 0;
        this.level = 2;
    }

    public int getLevel(){
        return this.level;
    }
    public void addlevel(){
        this.level++;
    }
    public void addreward(int r){
        this.cash += r;
    }

    public int getCash() {
        return this.cash;
    }
}
