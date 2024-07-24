package visual.GUI;

import Utils.Coordinates;
import data.BlockFactory;
import data.blocks.SandBlock;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import visual.textual.Map;
import java.util.Random;

public class ButtonListPane extends VBox {
    private TextField pick_row;
    private TextField pick_col;
    private Button pick;
    private HBox pick_box;
    private TextField inventory_ind;
    private Button move_to_furnace;
    private HBox inventory_box;
    private Button smelt;
    private Button move_back;
    private Button toggle_inventory;
    private MainGui mg;

    public ButtonListPane(MainGui gui) {
        super();
        this.mg = gui;
        super.setSpacing(10);
        this.pick = new Button("Pick");
        this.pick_row = new TextField();
        this.pick_row.setMaxWidth(40);
        this.pick_col = new TextField();
        this.pick_col.setMaxWidth(40);
        this.pick_box = new HBox();
        this.pick_box.getChildren().addAll(pick, pick_row, pick_col);
        this.move_to_furnace = new Button("Move to Furnace");
        this.inventory_ind = new TextField();
        this.inventory_ind.setMaxWidth(40);
        this.inventory_box = new HBox();
        this.inventory_box.getChildren().addAll(move_to_furnace, inventory_ind);
        this.smelt = new Button("Smelt");
        this.move_back = new Button("Move back");
        this.toggle_inventory = new Button("Toggle inventory sorting");


        super.getChildren().addAll(pick_box, inventory_box, smelt, move_back, toggle_inventory);
    }
}