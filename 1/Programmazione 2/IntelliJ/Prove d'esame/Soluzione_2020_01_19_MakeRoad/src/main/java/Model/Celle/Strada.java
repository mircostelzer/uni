package Model.Celle;

import Controller.MainGUI;
import Model.Cella;
import Model.Celle.Strade.StradaNord;
import Model.Celle.Strade.StradaSud;
import Model.Utils.Coordinate;
import View.*;
import View.Autos.AutoOrizzontale;
import View.Autos.AutoVerticale;
import View.Bottoni.BottoniCelle;
import View.Bottoni.BottoniGestione;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * La classe astratta Strada estende Cella e rappresenta una cella di tipo strada nella griglia.
 * Ogni cella di tipo strada può aggiungere una direzione e un'auto.
 */
public abstract class Strada extends Cella {

    /**
     * Costruisce una nuova istanza di Strada con il colore predefinito.
     *
     * @param mg L'oggetto MainGUI associato.
     * @param coordinate La coordinata della cella nella griglia.
     */
    public Strada(MainGUI mg, Coordinate coordinate) {
        super(mg, coordinate, Color.DIMGRAY);
        aggiungiDirezione();
    }

    /**
     * Imposta l'azione della cella quando viene cliccata.
     * Se un bottone specifico è disabilitato, sostituisce la cella con un prato.
     * Se l'aggiunta di un'auto è abilitata, aggiunge un'auto alla cella.
     */
    @Override
    public void setCellaAction() {
        super.setOnMouseClicked(event -> {
            BottoniCelle bc = getMg().getBottoniCelle();
            BottoniGestione bg = getMg().getBottoniGestione();

            if (bc.getDisabled() != null) {
                MappaPane mp = getMg().getMappaPane();
                String s = bc.getDisabled().getText();

                int x = getCoordinate().getX();
                int y = getCoordinate().getY();

                if (s.equals("PRATO")) {
                    mp.replaceElement(new Prato(getMg(), getCoordinate()), y, x);
                }
            } else if (bg.getAggiungiAuto().isDisabled() && MainGUI.getCoordinateAuto() == null) {
                aggiungiAuto();
                MainGUI.setCoordinateAuto(getCoordinate());
            }
        });
    }

    /**
     * Aggiunge un'auto alla cella.
     * Se la strada è orientata nord o sud, aggiunge un'auto verticale.
     * Altrimenti, aggiunge un'auto orizzontale.
     */
    public void aggiungiAuto() {
        if (this instanceof StradaNord || this instanceof StradaSud)
            getChildren().add(new AutoVerticale());
        else
            getChildren().add(new AutoOrizzontale());
    }

    /**
     * Restituisce un cerchio nero con bordo giallo, utilizzato per rappresentare un punto sulla strada.
     *
     * @return Un oggetto Circle.
     */
    public Circle getCerchio() {
        Circle circle = new Circle(5);
        circle.setFill(Color.BLACK);
        circle.setStroke(Color.YELLOW);
        return circle;
    }

    /**
     * Metodo astratto per aggiungere la direzione alla strada.
     * Deve essere implementato dalle classi concrete.
     */
    public abstract void aggiungiDirezione();
}
