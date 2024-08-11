package view;

import controller.Controller;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.BiColorTile;
import model.MultiBiColorInterface;
import model.MultiColorTileInterface;
import model.tiles.TileInterface;



public class TilesPane extends StackPane {
    private Rectangle rectangle;
    private Circle circle;
    private Rectangle innerRectangle;
    private static int OUTER_DIM = 130;
    private static double INNER_DIM = 65;
    private TileInterface content;
    private Controller controller;

    public TilesPane(Controller controller) {
        super();
        this.controller = controller;
        this.content = this.controller.getTiles().stream().toList().get(0);
        this.rectangle = new Rectangle(OUTER_DIM, OUTER_DIM);
        innerRectangle = new Rectangle(INNER_DIM, INNER_DIM);
        circle = new Circle(INNER_DIM/2);

        this.redraw();

        super.setOnMouseClicked(mouseEvent -> {
            if (content instanceof MultiColorTileInterface) {
                this.controller.incrementPrimaryColorIndex();
                this.setFirstColor(Controller.colorRotation.get(Controller.PRIMARY_COLOR_INDEX));
                this.redraw();
            }
        });

        innerRectangle.setOnMouseClicked(mouseEvent -> {
            if (content instanceof MultiBiColorInterface) {
                this.controller.incrementSecondaryColorIndex();
                this.setSecondColor(Controller.colorRotation.get(Controller.SECONDARY_COLOR_INDEX));
                this.redraw();
                mouseEvent.consume();
            }
        });


        circle.setOnMouseClicked(mouseEvent -> {
            if (content instanceof MultiBiColorInterface) {
                this.controller.incrementSecondaryColorIndex();
                this.setSecondColor(Controller.colorRotation.get(Controller.SECONDARY_COLOR_INDEX));
                this.redraw();
                mouseEvent.consume();
            }
        });
    }

    public void redraw() {
        this.getChildren().clear();
        rectangle.setFill(content.getColor());
        this.getChildren().add(rectangle);
        if (content instanceof BiColorTile) {
            if (((BiColorTile) content).getShape().equals("Rectangle")) {
                innerRectangle.setFill(((BiColorTile) content).getSecondColor());

                this.getChildren().add(innerRectangle);
            } else if (((BiColorTile) content).getShape().equals("Circle")) {
                circle.setFill(((BiColorTile) content).getSecondColor());
                this.getChildren().add(circle);
            }
        }
    }

    public void setContent(TileInterface content) {
        this.content = content;
    }

    public void setFirstColor(Color color) {
        ((MultiColorTileInterface)content).setColor(color);
    }

    public void setSecondColor(Color color) {
        ((MultiBiColorInterface)content).setSecondColor(color);
    }

}
