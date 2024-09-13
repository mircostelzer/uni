package view;

import controller.Controller;
import javafx.scene.layout.BorderPane;
import model.FanCatalog;
import model.User;

public class MainGui extends BorderPane {
    private UserPane userPane;
    private ExpenseButtons expenseButtons;
    private SortButtonsPane sortButtonsPane;
    private AllFansPane fans;

    public MainGui(User user, FanCatalog fanCatalog, Controller controller) {
        userPane = new UserPane(user);
        expenseButtons = new ExpenseButtons(controller);
        sortButtonsPane = new SortButtonsPane(controller);
        fans = new AllFansPane(fanCatalog, user, controller);

        this.setTop(userPane);
        this.setCenter(fans);
        this.setLeft(expenseButtons);
        this.setRight(sortButtonsPane);
    }

    public void redraw() {
        userPane.redraw();
        fans.redraw();
    }
}
