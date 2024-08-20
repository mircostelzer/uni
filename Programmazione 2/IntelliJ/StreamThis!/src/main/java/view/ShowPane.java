package view;

import controller.Controller;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.shows.Anime;
import model.shows.Film;
import model.shows.TVShow;

public class ShowPane extends StackPane {
    private Rectangle rectangle;
    private Text text;
    private Film show;
    private Controller controller;
    private final Color FILM_COLOR = Color.CYAN;
    private final Color SHOW_COLOR = Color.MAGENTA;
    private final Color ANIME_COLOR = Color.SALMON;

    public ShowPane(Film show, Controller controller) {
        this.show = show;
        this.controller = controller;
        intialise();
        this.setOnMouseClicked(e -> this.controller.selectShow(this.show));
    }

    private void intialise() {
        rectangle = new Rectangle(130, 40);
        if (this.show instanceof Anime) {
            rectangle.setFill(ANIME_COLOR);
        } else if (this.show instanceof TVShow) {
            rectangle.setFill(SHOW_COLOR);
        } else {
            rectangle.setFill(FILM_COLOR);
        }


        text = new Text(this.show.shortInfo());
        this.getChildren().addAll(rectangle, text);
    }

}
