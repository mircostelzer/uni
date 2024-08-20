package view;

import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.Geraldo;

public class GeraldoPane extends HBox {

    private Text tg;

    public GeraldoPane(Geraldo g){
        tg = new Text("Geraldo. LV: "+g.getLevel()+" GP: "+g.getCash());
        this.getChildren().add(tg);
    }

    public void redraw (Geraldo g){
        tg.setText("Geraldo. LV: "+g.getLevel()+" " + "GP: "+g.getCash());
    }
}
