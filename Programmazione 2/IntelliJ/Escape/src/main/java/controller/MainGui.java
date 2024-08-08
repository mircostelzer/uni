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
    private int iterations;
    private BallFactory bf;
    private List<BallsInterface> BallList;
    private UserBall userBall;
    private Player player;
    private GameOverPane gameOverPane;

    public MainGui(Player player) {
        bf = new BallFactory();
        iterations = 0;
        this.player = player;
        this.gameOverPane = new GameOverPane(player);
        this.BallList = new ArrayList<>();
        this.userBall = bf.createUserBall();
        this.getChildren().add(userBall.getCircle());
        this.addBall(bf.createBubbler());
        this.addBall(bf.createStriker());
        this.addBall(bf.createWanderer());
        this.setPrefSize(500, 500);

        this.setOnKeyPressed(keyEvent -> {
            this.iterations++;
            this.player.setPoints(this.player.getPoints() + 100);

            for (BallsInterface ball : BallList) {
                if (ball.getBallType() != BallType.Striker) {
                    if (iterations % 5 == 0) {
                        ball.setDirection(bf.randomDirections());
                    }
                    if (ball.getBallType() == BallType.Bubbler) {
                        Random rand = new Random();
                        if (rand.nextInt(10) == 3) {
                            ((Bubbler)ball).setDimension(((Bubbler)ball).getDimension() * 1.2);
                        }
                    }
                }
                ball.move();
                ball.pacmanEffect();
            }

            if (iterations % 10 == 0) {
                this.addRandomBall();
            }
            switch (keyEvent.getCode()) {
                case W: {
                    this.userBall.setDirection(Directions.Up);
                    this.userBall.move();
                    break;
                }
                case S: {
                    this.userBall.setDirection(Directions.Down);
                    this.userBall.move();
                    break;
                }
                case A: {
                    this.userBall.setDirection(Directions.Left);
                    this.userBall.move();
                    break;
                }
                case D: {
                    this.userBall.setDirection(Directions.Right);
                    this.userBall.move();
                    break;
                }
            }

            for (BallsInterface ball : BallList) {
                if (checkCollision(ball)) {
                    ball.getCircle().setFill(Paint.valueOf("Red"));
                    userBall.getCircle().setFill(Paint.valueOf("Red"));

                    gameOverPane.redraw();
                    Scene loseScene = new Scene(gameOverPane, 200, 100);
                    Stage loseStage = new Stage();
                    loseStage.setScene(loseScene);
                    loseStage.show();
                }
            }
        });
    }

    private void addBall(BallsInterface ball) {
        if (checkCollision(ball)) {
            switch(ball.getBallType()) {
                case Bubbler -> this.addBall(bf.createBubbler());
                case Striker -> this.addBall(bf.createStriker());
                case Wanderer -> this.addBall(bf.createWanderer());
            }
        }
        this.BallList.add(ball);
        this.getChildren().add(ball.getCircle());
    }

    private void addRandomBall() {
        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0 -> this.addBall(bf.createBubbler());
            case 1 -> this.addBall(bf.createStriker());
            default -> this.addBall(bf.createWanderer());
        }
    }

    public boolean checkCollision(BallsInterface ball) {
        return userBall.getCircle().intersects(ball.getCircle().getLayoutBounds());
    }


}
