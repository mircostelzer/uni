package gui;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import model.Direction;
import model.Player;
import model.entities.Character;
import model.entities.Entity;
import model.entities.Finish;
import model.entities.enemies.Block;
import model.entities.enemies.Enemy;
import model.entities.enemies.Penalty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGui extends BorderPane {
    private Player player;
    private PlayerPane playerPane;
    private Character character;
    private List<Enemy> enemies;
    private Pane playground;
    private Finish finish;
    private Scene scene;
    private final int BLOCKS = 3;
    private final int PENALTIES = 3;

    public MainGui(Player player) {
        this.player = player;
        this.playerPane = new PlayerPane(player);
        this.enemies = new ArrayList<>();
        this.character = new Character();
        this.playground = new Pane();
        this.finish = new Finish(490, 0);
        playground.setPrefSize(500, 200);
        playground.getChildren().addAll(character, finish.getShape());
        this.setTop(playerPane);
        this.setCenter(playground);
        this.addEnemies();

    }

    public void setScene(Scene scene) {
        this.scene = scene;
        this.scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP: {
                    character.setDirection(Direction.Up);
                    character.move();
                    this.moveAll();
                    break;
                }
                case DOWN: {
                    character.setDirection(Direction.Down);
                    character.move();
                    this.moveAll();
                    break;
                }
                case SPACE: {
                    this.moveAll();
                    break;
                }
                default: {}
            }

        });
    }

    private void moveAll() {
        player.setPoints(player.getPoints() + 100);
        for (Enemy e : enemies) {
            e.move();
        }
        finish.move();
        this.checkCollisions();
        if (player.isDead()) {
            this.gameOverAlert(false);
        }
        this.playerPane.refresh();
    }


    public void addEnemies() {
        Random x = new Random();
        Random y = new Random();
        for (int i = 0; i < BLOCKS; i++) {
            Block block = new Block(x.nextInt(410)+50, y.nextInt(170)+10);
            playground.getChildren().add(block.getShape());
            enemies.add(block);
        }

        for (int i = 0; i < PENALTIES; i++) {
            Penalty penalty = new Penalty(x.nextInt(420)+50, y.nextInt(180)+10);
            playground.getChildren().add(penalty.getShape());
            enemies.add(penalty);
        }
    }


    private boolean enemyCollision(Entity entity, Enemy enemy) {
//            if (enemy instanceof Block) {
                return (enemy.getShape().getBoundsInParent().intersects(entity.getShape().getBoundsInParent()));
//            } else {
//                double x1 = entity.getShape().getLayoutX();
//                double x2 = enemy.getShape().getLayoutX();
//                double y1 = entity.getShape().getLayoutY();
//                double y2 = enemy.getShape().getLayoutY();
//                return (Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) <= Penalty.DIM);
//            }
    }

    private void checkCollisions() {
        for (Enemy e : enemies) {
            if (enemyCollision(character, e)) {
                e.hit(player);
            }
        }
        if (finish.getShape().getBoundsInParent().intersects(character.getBoundsInParent())) {
            this.gameOverAlert(true);
        }
    }

    public void gameOverAlert(boolean win) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        if (win) {
            alert.setHeaderText("Hai totalizzato " + player.getPoints() + " punti");
        } else {
            alert.setHeaderText("Hai terminato le vite a disposizione");
        }
        alert.showAndWait();
        System.exit(0 );
    }
}
