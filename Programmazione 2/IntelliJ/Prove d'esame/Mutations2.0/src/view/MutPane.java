package view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.mutations.abstracts.AbstractMutation;

public class MutPane extends StackPane {

    public static final int DIM = 50;

    private AbstractMutation m;

    private Rectangle r;
    private Text t;

    public MutPane(AbstractMutation m){
        this.m = m;
        refresh();
    }

    public void refresh(){
        r = new Rectangle(DIM, DIM);
        r.setStroke(Color.BLACK);
        r.setFill(this.m.getMutationColor());

        String prefix = "+";
        if (m.isIsequipped()){
            prefix = "-";
        }
        String text = prefix+" "+this.m.getMutation().name();
        t = new Text(text);

        this.getChildren().removeAll(this.getChildren());
        this.getChildren().add(r);
        this.getChildren().add(t);
    }
}
