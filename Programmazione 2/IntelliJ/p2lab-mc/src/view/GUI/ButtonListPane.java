package view.GUI;

import controller.main.MainControllerInterface;
import data.BlockFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.MapCoordinates;

public class ButtonListPane extends VBox {
    Button pick_block_button;
    TextField pick_row_text;
    TextField pick_col_text;
    HBox pick_block_hbox;
    Button smelt_button;
    Button move_to_furnace_button;
    TextField inventory_index_text;
    HBox move_to_furnace_hbox;
    Button move_to_inventory_button;

    private MainControllerInterface mc;

    public ButtonListPane(MainControllerInterface m){
        super();

        mc = m;

        pick_block_hbox = new HBox();
        pick_row_text = new TextField();
        pick_block_hbox.getChildren().add(pick_row_text);
        pick_col_text = new TextField();
        pick_block_hbox.getChildren().add(pick_col_text);
        create_pick_button();
        pick_block_hbox.getChildren().add(pick_block_button);
        super.getChildren().add(pick_block_hbox);

        move_to_furnace_hbox = new HBox();
        inventory_index_text = new TextField();
        move_to_furnace_hbox.getChildren().add(inventory_index_text);
        create_move_to_furnace_button();
        move_to_furnace_hbox.getChildren().add(move_to_furnace_button);
        super.getChildren().add(move_to_furnace_hbox);

        create_smelt_button();
        super.getChildren().add(smelt_button);

        create_move_to_inventory_button();
        super.getChildren().add(move_to_inventory_button);

        Button b = new Button("Test");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            }
        });
        super.getChildren().add(b);
    }

    private void create_move_to_inventory_button() {
        move_to_inventory_button = new Button("Move to Inventory");
        move_to_inventory_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mc.move_from_furnace_to_inventory();
            }
        });
    }

    private void create_move_to_furnace_button() {
        move_to_furnace_button = new Button("Move to Furnace");
        move_to_furnace_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int index = Integer.parseInt(inventory_index_text.getText());
                mc.move_from_inventory_to_furnace(index);
            }
        });
    }

    private void create_smelt_button() {
        smelt_button = new Button("Smelt");
        smelt_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mc.smelt();
            }
        });
    }

    private void create_pick_button() {
        pick_block_button = new Button("Pick Block");
        pick_block_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int row = Integer.parseInt(pick_row_text.getText());
                int col = Integer.parseInt(pick_col_text.getText());
                MapCoordinates c = new MapCoordinates(row,col);
                mc.pick_block(c);
            }
        });
    }
}
