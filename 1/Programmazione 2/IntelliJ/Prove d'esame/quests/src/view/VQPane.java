package view;

import controller.GeraldoController;
import controller.QuestController;
import controller.SorterController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.quests.Quest;
import java.util.ArrayList;

public class VQPane extends VBox {

    private VBox vb;
    private Button bsbn;
    private Button bsbr;
    private GeraldoController g;

    public VQPane(GeraldoController g, SorterController sc){
        this.g = g;
        vb = new VBox();
        bsbn = new Button("Ordina per Nome");
        bsbn.setOnAction(
                (e) -> {
                    sc.sortByName();
                }
        );
        bsbr = new Button("Ordina per Ricompensa");
        bsbr.setOnAction(
                (e) -> {
                    sc.sortByRicompensa();
                }
        );

        this.getChildren().add(vb);
        this.getChildren().add(bsbn);
        this.getChildren().add(bsbr);

        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(5);
    }

    public void redraw(ArrayList<Quest> aq) {
        for(int i = 0 ; i < aq.size(); i++){
            Quest q = aq.get(i);
            QuestController qc = new QuestController(q, g);
            this.vb.getChildren().add(qc.getQp());
        }
    }
    public void clearQuests(){
        this.getChildren().clear();
        vb = new VBox();
        this.getChildren().add(vb);
        this.getChildren().add(bsbn);
        this.getChildren().add(bsbr);
    }
}
