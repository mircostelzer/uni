package visual.GUI;

import controllers.MainControllerInterface;
import controllers.MainSimpleController;
import Utils.Coordinates;
import controllers.MainVisualInterface;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    private CheckBox pickaxe;
    private MainVisualInterface mainController;

    public ButtonListPane(MainVisualInterface mc) {
        super();
        this.mainController = mc;
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
        this.pickaxe = new CheckBox("Pickaxe");

        this.pick.setOnMouseClicked(mouseEvent -> {
            int x = Integer.parseInt(pick_row.getText());
            int y = Integer.parseInt(pick_col.getText());
            this.pick_row.clear();
            this.pick_col.clear();

            this.mainController.pick_up_block(new Coordinates(x, y));
        });

        this.move_to_furnace.setOnMouseClicked(mouseEvent -> {
            int i = Integer.parseInt(inventory_ind.getText());
            this.inventory_ind.clear();

            this.mainController.move_into_furnace_from_inventory(i);
        });

        this.smelt.setOnMouseClicked(mouseEvent -> {
            this.mainController.smelt();
        });

        this.move_back.setOnMouseClicked(mouseEvent -> {
            this.mainController.move_into_inventory_from_furnace();
        });

        this.toggle_inventory.setOnMouseClicked(mouseEvent -> {
            this.mainController.toggle_inventory_comparator();
        });


        super.getChildren().addAll(pick_box, inventory_box, smelt, move_back, toggle_inventory, pickaxe);
    }

    public boolean is_active() {
        return this.pickaxe.isSelected();
    }
}