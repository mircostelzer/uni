package visual.GUI;

import data.blocks.interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import visual.textual.Inventory;

public class InventoryPane extends HBox {
    private Text text;
    private HBox inventory;

    public InventoryPane() {
        super();
        this.initialise();
        this.inventory = new HBox();
        super.getChildren().add(this.inventory);
    }

    private void initialise() {
        this.text = new Text("Inventory: ");
        StackPane sp = new StackPane();
        Rectangle rect = new Rectangle(BlockPane.DIM_SQUARE, BlockPane.DIM_SQUARE);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.TRANSPARENT);
        sp.getChildren().add(rect);
        sp.getChildren().add(text);
        super.getChildren().add(sp);
    }

}
