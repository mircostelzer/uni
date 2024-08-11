package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.MultiBiColorInterface;
import model.MultiColorTileInterface;
import model.tiles.TileInterface;

import java.awt.*;

public class MainGui extends TilePane {
    private InfoPane infoPane;
    private TilesPane tilesPane;

    public MainGui(Controller controller) {
        super.setPadding(new Insets(20, 20, 20, 20));
        infoPane = new InfoPane(controller);
        tilesPane = new TilesPane(controller);
        this.getChildren().addAll(infoPane, tilesPane);



    }

    public void redraw() {
        infoPane.redraw();
        tilesPane.redraw();
    }

    public void setContent(TileInterface content) {
        infoPane.setContent(content);
        tilesPane.setContent(content);
    }

    public InfoPane getInfoPane() {
        return infoPane;
    }

    public TilesPane getTilesPane() {
        return tilesPane;
    }

}
