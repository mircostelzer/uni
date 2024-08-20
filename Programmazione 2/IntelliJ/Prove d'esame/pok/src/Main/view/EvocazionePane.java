package Main.view;

import Main.model.summons.Evocazione;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class EvocazionePane extends StackPane {
    private final int squaresize = 100;
    private final int bordersize = 10;

    private Rectangle rsfondo = new Rectangle(squaresize, squaresize);
    private Rectangle rcentro = new Rectangle( squaresize-bordersize, squaresize-bordersize);
    private Evocazione evocazione;

    public EvocazionePane(Evocazione p){
        this.evocazione = p;
        this.rsfondo.setFill(p.getBorderColor());
        this.rcentro.setFill(this.evocazione.getEnergyType().getColor());
        this.getChildren().add(rsfondo);
        this.getChildren().add(rcentro);
        Text fline = new Text(evocazione.getFirstLine()+
                "\n"+evocazione.getSecondLine()+
                "\n"+evocazione.getThirdLine()+
                "\n"+evocazione.getFourthLine());
        this.getChildren().add(fline);
    }

    public Evocazione getEvocazione() {
        return this.evocazione;
    }
}
