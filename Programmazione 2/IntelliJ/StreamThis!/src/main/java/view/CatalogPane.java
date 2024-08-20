package view;

import controller.Controller;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.FilmCatalog;

public class CatalogPane extends HBox {
    private Button prev;
    private Button next;
    private FilmCatalog catalog;
    private Controller controller;
    private int index;

    public CatalogPane(FilmCatalog catalog, Controller controller) {
        this.catalog = catalog;
        this.controller = controller;
        index = 0;
        prev = new Button("<");
        next = new Button(">");
        setNavigationButtons();
        redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        this.getChildren().add(prev);
        for (int i = index; i < index+3; i++) {
            this.getChildren().add(new ShowPane(catalog.getShows().get(i), controller));
        }
        this.getChildren().add(next);
    }

    private void setNavigationButtons() {
        prev.setOnMouseClicked(e -> {
            if (index > 0) {
                index--;
                this.redraw();
            } else {
                this.alertMessage();
            }
        });

        next.setOnMouseClicked(e -> {
            if (index < this.catalog.getShows().size() - 3) {
                index++;
                this.redraw();
            } else {
                this.alertMessage();
            }
        });
    }

    private void alertMessage() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Invalid operation");
        alert.show();
    }
}
