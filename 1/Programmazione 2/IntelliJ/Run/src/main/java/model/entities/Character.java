package model.entities;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;
import model.Direction;
import model.Player;

public class Character extends Group implements Entity{
    private Direction direction;
    private Player player;
    private Circle circle;
    private Polygon polygon;
    private final int RADIUS = 5;
    private final Color CIRCLE_COLOR = Color.BLACK;
    private final Color TRIANGLE_COLOR = Color.GREEN;

    public Character() {
        circle = new Circle(0, 0, RADIUS);
        circle.setFill(CIRCLE_COLOR);
        polygon = new Polygon();
        polygon.setFill(TRIANGLE_COLOR);
        polygon.getPoints().addAll(0.0, 0.0, 5.0, 30.0, -5.0, 30.0);
        this.setLayoutX(20);
        this.setLayoutY(100);
        this.getChildren().addAll(polygon, circle);
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

    @Override
    public void move() {
        switch (direction) {
            case Up -> this.setLayoutY(this.getLayoutY() - 10);
            case Down -> this.setLayoutY(this.getLayoutY() + 10);
        }
    }

    @Override
    public Node getShape() {
        return this;
    }
}
