package View;

import Controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Classe per creare il pannello dei bottoni per la gestione delle spese.
 */
public class BottoniSpesa extends VBox {
    private Button prossimoMese;
    private Button aumentaFondi;

    /**
     * Costruttore per creare il pannello dei bottoni per la gestione delle spese.
     *
     * @param mg L'istanza di MainGUI.
     */
    public BottoniSpesa(MainGUI mg) {
        super();
        prossimoMese = new Button("Prox Mese");
        aumentaFondi = new Button("+ 100 Fondi");

        setProssimoMeseAction(mg);
        setAumentaFondiAction(mg);

        getChildren().addAll(prossimoMese, aumentaFondi);
    }

    /**
     * Imposta l'azione per il bottone di aumento dei fondi.
     *
     * @param mg L'istanza di MainGUI.
     */
    private void setAumentaFondiAction(MainGUI mg) {
        aumentaFondi.setOnAction(event -> {
            mg.getStatsPane().aggiornaCapitale(100);
            mg.aggiornaCostosi();
        });
    }

    /**
     * Imposta l'azione per il bottone di passaggio al prossimo mese.
     *
     * @param mg L'istanza di MainGUI.
     */
    private void setProssimoMeseAction(MainGUI mg) {
        prossimoMese.setOnAction(event -> mg.meseSuccessivo());
    }
}