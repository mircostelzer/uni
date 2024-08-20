package view;

import controller.GeraldoController;
import controller.QuestController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Geraldo;
import model.quests.Quest;

public class QuestPane extends VBox {

    private Rectangle r;
    private StackPane sp;
    private Text t;
    private Button b;
    private QuestController qc;

    public QuestPane(Quest q, QuestController qc, GeraldoController g){
        this.qc = qc;
        r = new Rectangle(240,60);
        t = new Text(q.getMainInfo()+"\n"+q.getSecondaryInfo());
        sp = new StackPane();
        sp.getChildren().add(r);
        sp.getChildren().add(t);
        b = new Button("Completa");
        b.setOnAction(e ->{
            this.qc.solvequest();
        }  );
        this.getChildren().add(sp);
        this.getChildren().add(b);
        this.setAlignment(Pos.CENTER);
        this.redraw(q, g);
    }

    public void redraw(Quest q, GeraldoController gc){
        Geraldo g = gc.getG();
        if (q.is_solved()) {
            r.setFill(Color.LIGHTGREEN);
        }else{
            r.setFill(Color.BEIGE);
        }
        if (q.is_solved()){
            this.b.setDisable(true);
        }
    }

}
