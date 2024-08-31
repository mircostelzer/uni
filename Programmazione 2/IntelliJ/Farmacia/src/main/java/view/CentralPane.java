package view;

import Main.Main;
import controller.BuyHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Medicina;
import model.User;

public class CentralPane extends VBox {
    private Medicina medicina;
    private Text text;
    private Button buy;
    private User user;
    private MainGui mainGui;

    public CentralPane(User user, MainGui mainGui) {
        this.user = user;
        this.mainGui = mainGui;
    }

    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
        this.refresh();
    }

    public void refresh() {
        this.getChildren().clear();
        this.text = new Text(medicina.toString());
        this.buy = new Button("Compra");
        this.buy.setOnMouseClicked(new BuyHandler(this.user, this.medicina, this.mainGui));
        this.getChildren().addAll(text, buy);
    }
}
