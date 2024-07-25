package visual.GUI;

import data.blocks.interfaces.Block;
import javafx.geometry.Pos;
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
    }

    public void initialise() {
        this.addInventoryText();
        this.inventory = new HBox();
        super.getChildren().add(this.inventory);
    }

    public void addInventoryText() {
        this.text = new Text("Inventory:");
        this.text.setFont(Font.font("VERDANA", BlockPane.FONT_WEIGHT, 8));
        this.text.setTextAlignment(TextAlignment.CENTER);
        StackPane sp = new StackPane();
        Rectangle rect = new Rectangle(BlockPane.DIM_SQUARE, BlockPane.DIM_SQUARE);
        rect.setFill(Color.TRANSPARENT);
        rect.setStroke(Color.TRANSPARENT);
        rect.setStroke(BlockPane.BLOCK_BORDER);
        sp.getChildren().add(rect);
        sp.getChildren().add(text);
        sp.setAlignment(Pos.CENTER_LEFT);
        super.getChildren().add(sp);
    }

    public void addBlock(Block block) {
        BlockPane bp = new BlockPane(block);
        this.inventory.getChildren().add(bp);
    }
}
