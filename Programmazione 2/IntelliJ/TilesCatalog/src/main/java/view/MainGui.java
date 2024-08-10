package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.MultiColorTileInterface;
import model.tiles.TileInterface;

import java.awt.*;

public class MainGui extends TilePane {
    private InfoPane infoPane;
    private TilesPane tilesPane;

    public MainGui() {
        super.setPadding(new Insets(10, 10, 10, 10));
        infoPane = new InfoPane();
        tilesPane = new TilesPane();

    }

    public void redraw() {
        infoPane.redraw();
        tilesPane.redraw();
    }

    public void setContent(TileInterface content) {

    }

    public InfoPane getInfoPane() {
        return infoPane;
    }

    public TilesPane getTilesPane() {
        return tilesPane;
    }

}
