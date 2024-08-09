package controller;

import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.BallFactory;
import model.BallsInterface;
import model.Directions;
import model.Player;
import model.balls.BallType;
import model.balls.Bubbler;

import java.util.Random;

public class Controller {
    private MainGui mainGui;
    private Player player;
    private BallFactory bf;
    private Scene scene;

    public Controller(Player player, Scene scene, MainGui mainGui) {
        this.mainGui = mainGui;
        this.player = player;
        this.scene = scene;
        this.bf = mainGui.getBallFactory();
        this.scene.setOnKeyPressed(keyEvent -> {
            mainGui.iterations++;
            this.player.setPoints(this.player.getPoints() + 100);

            for (BallsInterface ball : this.mainGui.getBallList()) {
                if (ball.getBallType() != BallType.Striker) {
                    if (mainGui.iterations % 5 == 0) {
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

            if (mainGui.iterations % 10 == 0) {
                this.mainGui.addRandomBall();
            }
            switch (keyEvent.getCode()) {
                case W: {
                    this.mainGui.getUserBall().setDirection(Directions.Up);
                    this.mainGui.getUserBall().move();
                    this.mainGui.getUserBall().pacmanEffect();
                    break;
                }
                case S: {
                    this.mainGui.getUserBall().setDirection(Directions.Down);
                    this.mainGui.getUserBall().move();
                    this.mainGui.getUserBall().pacmanEffect();
                    break;
                }
                case A: {
                    this.mainGui.getUserBall().setDirection(Directions.Left);
                    this.mainGui.getUserBall().move();
                    this.mainGui.getUserBall().pacmanEffect();
                    break;
                }
                case D: {
                    this.mainGui.getUserBall().setDirection(Directions.Right);
                    this.mainGui.getUserBall().move();
                    this.mainGui.getUserBall().pacmanEffect();
                    break;
                }
            }

            for (BallsInterface ball : this.mainGui.getBallList()) {
                if (this.mainGui.checkCollision(ball)) {
                    ball.getCircle().setFill(Paint.valueOf("Red"));
                    this.mainGui.getUserBall().getCircle().setFill(Paint.valueOf("Red"));

                    this.mainGui.getGameOverPane().redraw();
                    Scene loseScene = new Scene(this.mainGui.getGameOverPane(), 200, 100);
                    Stage loseStage = new Stage();
                    loseStage.setScene(loseScene);
                    loseStage.show();
                }
            }
        });
    }

}
