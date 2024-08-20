package controller;

import javafx.scene.control.Alert;
import model.Geraldo;
import model.exceptions.InsufficientLevelException;
import model.exceptions.PreviousQuestNotCompletedException;
import model.quests.Quest;
import view.GeraldoPane;
import view.QuestPane;

public class QuestController {

    private GeraldoController g;
    private Quest q;
    private QuestPane qp;

    public QuestController(Quest qq, GeraldoController g){
        this.q = qq;
        this.g = g;
        this.qp = new QuestPane(this.q, this, g);
    }

    public QuestPane getQp() { return qp; }

    public void solvequest(){
        try {
            Geraldo ge = this.g.getG();
            GeraldoPane gp = this.g.getGp();
            this.q.solve(ge);
            this.qp.redraw(this.q, this.g);
            gp.redraw(ge);
        } catch (PreviousQuestNotCompletedException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Previous quest not completed");
            a.showAndWait();
        } catch (InsufficientLevelException e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Insufficient level");
            a.showAndWait();
        }
    }
}
