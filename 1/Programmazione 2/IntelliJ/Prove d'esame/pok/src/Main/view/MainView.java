package Main.view;

import Main.controller.EnergyController;
import Main.controller.EvocazioneController;
import Main.model.Giocatore;
import Main.model.energies.Energy;
import Main.model.summons.Evocazione;
import javafx.geometry.Pos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {

    private Giocatore g1;
    private Giocatore g2;

    protected VBox g1en;
    protected VBox g2en;
    protected HBox g1ev;
    protected HBox g2ev;

    public MainView(Giocatore g1, Giocatore g2){
        this.g1 = g1;
        this.g2 = g2;
        this.setup();
    }
    private void setupenergies(Giocatore g, VBox pane){
        for (Energy e : g.getEnergie()){
            EnergyPane ep = new EnergyPane(e,pane.getChildren().size());
            pane.getChildren().add(ep);
            ep.addEventHandler(MouseEvent.MOUSE_CLICKED, new EnergyController(ep,g,this));
        }
    }
    private void setupevocazioni(Giocatore g, HBox pane){
        for (Evocazione e :g.getEvocazioni()) {
            EvocazionePane ep = new EvocazionePane(e);
            pane.getChildren().add(ep);
            ep.addEventHandler(MouseEvent.MOUSE_CLICKED, new EvocazioneController(ep,g,this));
        }
    }
    private void setup(){
        g1en = new VBox();
        g2en = new VBox();
        g1ev = new HBox();
        g2ev = new HBox();
        setupenergies(g1,g1en);
        setupenergies(g2,g2en);
        setupevocazioni(g1,g1ev);
        setupevocazioni(g2,g2ev);

        this.setLeft(g1en);
        g1en.setSpacing(10);
        ((VBox) this.getLeft()).setAlignment(Pos.BOTTOM_CENTER);

        this.setRight(g2en);
        g2en.setSpacing(10);
        ((VBox) this.getRight()).setAlignment(Pos.TOP_CENTER);

        this.setBottom(g1ev);
        g1ev.setSpacing(10);
        ((HBox) this.getBottom()).setAlignment(Pos.BOTTOM_LEFT);

        this.setTop(g2ev);
        g2ev.setSpacing(10);
        ((HBox) this.getTop()).setAlignment(Pos.TOP_RIGHT);
    }

    public void flipPlayers(){
        Giocatore tmp = this.g1;
        this.g1 = this.g2;
        this.g2 = tmp;
        this.setup();
    }

    public void refresh(){
        this.setup();
    }

    public boolean is_g1(Giocatore g){
        return g == g1;
    }
}
