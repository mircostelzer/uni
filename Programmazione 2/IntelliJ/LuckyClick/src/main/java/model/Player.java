package model;

import model.cells.functions.MyConsumer;

public class Player {
    private int points = 0;
    private int tries;

    public Player(int tries) {
        this.tries = tries;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public void applyModifier(MyConsumer<Player> c) {
        c.accept(this);
    }
}
