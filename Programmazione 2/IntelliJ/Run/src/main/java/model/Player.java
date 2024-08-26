package model;

public class Player {
    private int points;
    private int lives;

    public Player() {
        this.points = 0;
        this.lives = 3;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isDead() {
        return lives <= 0;
    }
}
