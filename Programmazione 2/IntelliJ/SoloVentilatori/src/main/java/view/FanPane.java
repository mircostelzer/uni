package view;

import controller.Controller;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import model.User;
import model.interfaces.FanInterface;

public class FanPane extends HBox {
    private Circle fan;
    private Text info;
    private FanInterface content;
    private User user;
    private Controller controller;
    private static final Color SUBSCRIBED = Color.RED;
    private static final Color UNSUBSCRIBED = Color.BLUE;
    private static final Color CAN_PURCHASE = Color.BLACK;
    private static final Color CANNOT_PURCHASE = Color.GRAY;

    public FanPane(FanInterface content, User user, Controller controller) {
        this.content = content;
        this.user = user;
        this.controller = controller;
        this.redraw();
    }

    public void redraw() {
        fan = new Circle(20);
        fan.setStrokeWidth(4);
        if (content.getSubscription()) {
            fan.setFill(SUBSCRIBED);
        } else {
            fan.setFill(UNSUBSCRIBED);
        }
        if (user.canPurchase(content)) {
            fan.setStroke(CAN_PURCHASE);
        } else {
            fan.setStroke(CANNOT_PURCHASE);
        }
        this.getChildren().add(fan);
        info = new Text(content.toString());
        this.getChildren().add(info);

        fan.setOnMouseClicked(mouseEvent -> {
            if ((!content.getSubscription()) && user.canPurchase(content)) {
                controller.subscribe(content);
            }
        });
    }
}
