package GUI;

import data.blocks.interfaces.Block;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import visual.Inventory;

public class InventoryPane extends HBox {
    private Text text;
    private HBox hBox;
    private Inventory inventory;

    public InventoryPane() {
        super();
        this.initialise();
        this.inventory = new Inventory();
        this.getChildren().addAll(this.text, this.hBox);
    }

    private void initialise() {
        this.text = new Text("Inventory");
        this.text.setTextAlignment(TextAlignment.CENTER);
        this.text.setFont(Font.font("Verdana"));
        this.text.setFill(Paint.valueOf("BLACK"));
        this.hBox = new HBox();
    }

    public void addBlock(Block b) {
        this.inventory.add_block(b);
        this.hBox.getChildren().add(new BlockPane(b));
    }

}
