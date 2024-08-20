package view;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.shows.Film;
import model.shows.TVShow;


public class InfoPane extends VBox {
    private Text info;
    private Film show;
    private Button buyButton;

    public InfoPane() {
        this.setAlignment(Pos.CENTER);
    }

    public void redraw() {
        this.getChildren().clear();
        info = new Text(show.completeInfo());
        info.setTextAlignment(TextAlignment.CENTER);
        this.getChildren().add(info);
        if (show instanceof TVShow) {
            ((TVShow)show).reset();
            HBox hbox = new HBox();
            for (int i=0; i < ((TVShow)show).getSeasonNumber(); i++) {
                Button season = new Button("S"+(i+1));
                season.setOnMouseClicked(e -> {
                    ((TVShow)show).selectSeason();
                    season.setDisable(true);
                    this.refreshBuyButton();
                });
                hbox.getChildren().add(season);
            }
            this.getChildren().add(hbox);
            hbox.setAlignment(Pos.CENTER);
        }
        this.refreshBuyButton();
    }

    public void refreshBuyButton() {
        this.getChildren().remove(buyButton);
        buyButton = new Button("Acquista " + show.getPrice());
        buyButton.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRORE:");
            alert.setHeaderText("connessione non presente");
            alert.show();
        });
        this.getChildren().add(buyButton);
    }

    public void setShow(Film show) {
        this.show = show;
        this.redraw();
    }

    public void clear() {
        this.getChildren().clear();
        if (show instanceof TVShow) {
            ((TVShow)show).reset();
        }
    }
}
