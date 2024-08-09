package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.*;
import model.balls.BallType;
import model.balls.Bubbler;
import model.balls.UserBall;
import view.GameOverPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGui extends Pane {
    public static int iterations;
    private BallFactory bf;
    private List<BallsInterface> BallList;
    private UserBall userBall;
    private GameOverPane gameOverPane;

    public MainGui(Player player) {
        bf = new BallFactory();
        iterations = 0;
        this.gameOverPane = new GameOverPane(player);
        this.BallList = new ArrayList<>();
        this.userBall = bf.createUserBall();
        this.getChildren().add(userBall.getCircle());
        this.addBall(bf.createBubbler());
        this.addBall(bf.createStriker());
        this.addBall(bf.createWanderer());
        this.setMaxSize(500, 500);
        this.setPrefSize(500, 500);
    }

    private void addBall(BallsInterface ball) {
        this.BallList.add(ball);
        this.getChildren().add(ball.getCircle());
        if (checkCollision(ball)) {
            this.BallList.remove(ball);
            this.getChildren().remove(ball.getCircle());
            switch(ball.getBallType()) {
                case Bubbler -> this.addBall(bf.createBubbler());
                case Striker -> this.addBall(bf.createStriker());
                case Wanderer -> this.addBall(bf.createWanderer());
            }
        }
    }

    public void addRandomBall() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0 -> this.addBall(bf.createBubbler());
            case 1 -> this.addBall(bf.createStriker());
            default -> this.addBall(bf.createWanderer());
        }
    }

    public boolean checkCollision(BallsInterface ball) {
        double distance = Math.sqrt(Math.pow(userBall.getCircle().getCenterX() - ball.getCircle().getCenterX(), 2) + Math.pow(userBall.getCircle().getCenterY() - ball.getCircle().getCenterY(), 2));
        return distance <= (userBall.getCircle().getRadius() + ball.getCircle().getRadius());
    }

    public BallFactory getBallFactory() {
        return bf;
    }

    public List<BallsInterface> getBallList() {
        return BallList;
    }

    public UserBall getUserBall() {
        return userBall;
    }

    public GameOverPane getGameOverPane() {
        return gameOverPane;
    }

}
