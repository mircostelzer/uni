package model.entities;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;
import model.Direction;
import model.Player;

public class Character implements Entity{
    private Direction direction;
    private Player player;
    private Group group;
    private Circle circle;
    private Polygon polygon;
    private final int RADIUS = 5;
    private final Color CIRCLE_COLOR = Color.BLACK;
    private final int TRIANGLE_WIDTH = 10;
    private final int TRIANGLE_HEIGHT = 30;
    private final Color TRIANGLE_COLOR = Color.GREEN;

    public Character(Player player) {
        this.player = player;
        this.group = new Group();
        circle = new Circle(0, 0, RADIUS);
        circle.setFill(CIRCLE_COLOR);
        polygon = new Polygon();
        polygon.setFill(TRIANGLE_COLOR);
        polygon.getPoints().addAll(0.0, 0.0, 5.0, 30.0, -5.0, 30.0);
        group.getChildren().addAll(polygon, circle);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Player getPlayer() {
        return player;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public void move() {

    }
}
