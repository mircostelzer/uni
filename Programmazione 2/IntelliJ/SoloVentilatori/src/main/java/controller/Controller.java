package controller;

import javafx.scene.control.Alert;
import model.AbstractFan;
import model.BrokeException;
import model.FanCatalog;
import model.User;
import model.interfaces.FanInterface;
import view.MainGui;

import java.util.Comparator;

public class Controller {
    private User user;
    private FanCatalog fanCatalog;
    private MainGui mainGui;

    public Controller(User user, FanCatalog fanCatalog) {
        this.user = user;
        this.fanCatalog = fanCatalog;
        this.mainGui = new MainGui(this.user, this.fanCatalog, this);
    }

    public void subscribe(FanInterface fan) {
        user.addFan(fan);
        user.setMonthlyExpense(user.getMonthlyExpense() + fan.getPrice());
        mainGui.redraw();
    }

    public void advanceMonth() {
        try {
            user.advanceMonth();
        } catch (BrokeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You're broke!");
            alert.show();
        }
        mainGui.redraw();
    }

    public void toggleComparator(Comparator<AbstractFan> comparator) {
        fanCatalog.toggleComparator(comparator);
        mainGui.redraw();
    }

    public void addToCapital(int money) {
        user.setCapital(user.getCapital() + money);
        mainGui.redraw();
    }

    public MainGui getMainGui() {
        return mainGui;
    }
}
