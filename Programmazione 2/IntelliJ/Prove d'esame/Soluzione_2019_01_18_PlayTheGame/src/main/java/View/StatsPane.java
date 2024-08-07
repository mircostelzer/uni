package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Rappresenta il pannello delle statistiche nella GUI principale del gioco.
 */
public class StatsPane extends HBox {
    private MainGUI mg;
    private int punteggio;
    private int partiteVinte;

    private Text punteggioText;
    private Text numeroText;
    private static Text partiteVinteText;

    /**
     * Costruttore del pannello delle statistiche.
     *
     * @param mg MainGUI a cui il pannello appartiene.
     */
    public StatsPane(MainGUI mg) {
        super();
        this.mg = mg;
        punteggio = 0;
        partiteVinte = 0;

        punteggioText = new Text("Punteggio");
        partiteVinteText = new Text("Partite vinte 0");
        numeroText = new Text();

        aggiornaPunteggioText(0);

        super.getChildren().addAll(punteggioText, numeroText, partiteVinteText);
        super.setSpacing(5);
    }

    /**
     * Restituisce il numero di partite vinte.
     *
     * @return Il numero di partite vinte.
     */
    public int getPartiteVinte() {
        return partiteVinte;
    }

    /**
     * Restituisce il punteggio attuale.
     *
     * @return Il punteggio attuale.
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * Aggiorna il testo relativo al punteggio e gestisce le azioni correlate al raggiungimento del punteggio massimo.
     *
     * @param nuovoPunteggio Il nuovo punteggio da visualizzare.
     */
    public void aggiornaPunteggioText(int nuovoPunteggio){
        punteggio = nuovoPunteggio;
        numeroText.setText(String.valueOf(punteggio));

        if(punteggio < 10)
            numeroText.setStroke(Color.BLUE);
        else if(punteggio > 10)
            numeroText.setStroke(Color.RED);
        else {
            System.out.println("Punteggio totale: 10");
            numeroText.setStroke(Color.GREEN);
            aggiornaPartiteVinteText();
            System.out.println("Hai vinto " + partiteVinte + " partite!");
            AlertDisplayer.display_WIN_Alert();
            mg.resetAll();
        }

        System.out.println("Punteggio totale: " + punteggio);
    }

    /**
     * Aggiorna il testo relativo al numero di partite vinte.
     */
    public void aggiornaPartiteVinteText(){
        partiteVinte++;
        partiteVinteText.setText("Partite vinte " + partiteVinte);
    }
}
