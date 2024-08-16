package view;

import controller.Controller;
import javafx.scene.layout.VBox;
import model.FanCatalog;
import model.User;
import model.interfaces.FanInterface;

public class AllFansPane extends VBox {
    private FanCatalog fanCatalog;
    private User user;
    private Controller controller;

    public AllFansPane(FanCatalog fanCatalog, User user, Controller controller) {
        this.fanCatalog = fanCatalog;
        this.user = user;
        this.controller = controller;
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        for (FanInterface fan : fanCatalog.getFans()) {
            this.getChildren().add(new FanPane(fan, user, controller));
        }
    }
}
