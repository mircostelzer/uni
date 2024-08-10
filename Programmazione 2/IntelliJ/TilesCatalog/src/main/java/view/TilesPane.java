package view;

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
    private static int OUTER_DIM = 130;
    private static double INNER_DIM = 65;
    private TileInterface content;

    public TilesPane() {
        super();
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        this.rectangle = new Rectangle();
        rectangle.setFill(content.getColor());
        this.getChildren().add(rectangle);
        if (content instanceof BiColorTile) {
            if (((BiColorTile) content).getShape().equals("Rectangle")) {
                Rectangle inner = new Rectangle(INNER_DIM, INNER_DIM);
                inner.setFill(((BiColorTile) content).getSecondColor());
                this.getChildren().add(inner);
            } else if (((BiColorTile) content).getShape().equals("Circle")) {
                Circle inner = new Circle(INNER_DIM);
                inner.setFill(((BiColorTile) content).getSecondColor());
                this.getChildren().add(inner);
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
