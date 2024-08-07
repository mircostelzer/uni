package Model.Celle;

import Controller.MainGUI;
import Model.Utils.AlertDisplayer;
import Model.Cella;
import Model.Celle.Strade.StradaEst;
import Model.Celle.Strade.StradaNord;
import Model.Celle.Strade.StradaOvest;
import Model.Celle.Strade.StradaSud;
import Model.Utils.Coordinate;
import View.Bottoni.BottoniCelle;
import View.Bottoni.BottoniGestione;
import View.MappaPane;
import javafx.scene.paint.Color;

/**
 * La classe Prato estende Cella e rappresenta una cella di prato nella griglia.
 */
public class Prato extends Cella {

    /**
     * Costruisce una nuova istanza di Prato con il colore verde predefinito.
     *
     * @param mg L'oggetto MainGUI associato.
     * @param coordinate La coordinata della cella nella griglia.
     */
    public Prato(MainGUI mg, Coordinate coordinate) {
        super(mg, coordinate, Color.GREEN);
    }

    /**
     * Imposta l'azione della cella quando viene cliccata.
     * Se un bottone specifico è disabilitato, sostituisce la cella con una strada nella direzione selezionata.
     * Se l'aggiunta di un'auto è abilitata, mostra un avviso di errore.
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

                switch (s) {
                    case "Strada NORD" -> mp.replaceElement(new StradaNord(getMg(), getCoordinate()), y, x);
                    case "Strada SUD" -> mp.replaceElement(new StradaSud(getMg(), getCoordinate()), y, x);
                    case "Strada EST" -> mp.replaceElement(new StradaEst(getMg(), getCoordinate()), y, x);
                    case "Strada OVEST" -> mp.replaceElement(new StradaOvest(getMg(), getCoordinate()), y, x);
                }
            } else if (bg.getAggiungiAuto().isDisabled()) {
                AlertDisplayer.display_warning_alert("la macchina non può essere aggiunta su un prato!");
                bg.getAggiungiAuto().setDisable(false);
                bg.getMuoviAuto().setDisable(true);
            }
        });
    }
}
