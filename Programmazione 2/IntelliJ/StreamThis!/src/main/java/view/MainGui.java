package view;

import controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import model.FilmCatalog;

public class MainGui extends BorderPane {
    private CatalogPane catalogPane;
    private InfoPane infoPane;
    private SortButtonsPane buttons;
    private Button clearButton;

    public MainGui(FilmCatalog filmCatalog, Controller controller) {
        catalogPane = new CatalogPane(filmCatalog, controller);
        buttons = new SortButtonsPane(controller);
        infoPane = new InfoPane();
        clearButton = new Button("Clear");
        clearButton.setOnMouseClicked(mouseEvent -> {
            infoPane.clear();
        });

        this.setTop(catalogPane);
        this.setLeft(clearButton);
        this.setRight(buttons);
        this.setCenter(infoPane);
    }

    public InfoPane getInfoPane() {
        return infoPane;
    }

    public CatalogPane getCatalogPane() {
        return catalogPane;
    }
}
