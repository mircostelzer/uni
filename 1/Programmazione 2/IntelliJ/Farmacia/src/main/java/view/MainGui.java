package view;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Farmacia;
import model.Medicina;
import model.User;

public class MainGui extends BorderPane {
    private MedicinePane medicinePane;
    private CentralPane centralPane;
    private RicettePane ricettePane;
    private Text userInfo;
    private User user;

    public MainGui(User user, Farmacia farmacia) {
        this.user = user;
        this.medicinePane = new MedicinePane(farmacia, this);
        this.centralPane = new CentralPane(user, this);
        centralPane.setAlignment(Pos.CENTER);
        this.ricettePane = new RicettePane(user.getRicette(), this);
        this.setUserInfo();

        this.setLeft(medicinePane);
        this.setCenter(centralPane);
        this.setRight(ricettePane);
    }

    public void setCenter(Medicina medicina) {
        this.centralPane.setMedicina(medicina);
        centralPane.refresh();
    }

    public void clearCenter() {
        this.centralPane.getChildren().clear();
    }

    public void refresh() {
        this.centralPane.refresh();
        this.ricettePane.refresh();
        this.setUserInfo();
    }

    private void setUserInfo() {
        this.userInfo = new Text(user.toString());
        userInfo.setTextAlignment(TextAlignment.LEFT);
        this.setBottom(userInfo);
    }
}
