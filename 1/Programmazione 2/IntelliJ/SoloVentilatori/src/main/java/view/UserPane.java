package view;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.User;

public class UserPane extends HBox {
    private User user;
    private Text text;

    public UserPane(User user) {
        this.user = user;
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        text = new Text(user.toString());
        text.setTextAlignment(TextAlignment.LEFT);
        this.getChildren().add(text);
    }
}
