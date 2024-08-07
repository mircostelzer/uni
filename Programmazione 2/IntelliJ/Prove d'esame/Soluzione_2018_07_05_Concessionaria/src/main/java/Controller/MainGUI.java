package Controller;

import Model.Concessionaria;
import View.ButtonPane;
import View.CarPane;
import javafx.scene.layout.AnchorPane;

/**
 * La classe MainGUI rappresenta l'interfaccia principale dell'applicazione.
 * Contiene una concessionaria di automobili, un pannello per visualizzare le informazioni dell'automobile corrente e un pannello di pulsanti per la navigazione e il cambio di ordinamento.
 */
public class MainGUI extends AnchorPane {
    private static int GENERAL_INDEX = 0; // Indice generale per l'automobile corrente
    private Concessionaria concessionaria; // Concessionaria di automobili

    private CarPane carPane; // Pannello per visualizzare le informazioni dell'automobile corrente
    private ButtonPane buttonPane; // Pannello di pulsanti per la navigazione e il cambio di ordinamento

    /**
     * Costruttore per la classe MainGUI.
     * Crea una nuova istanza di MainGUI e inizializza la concessionaria di automobili, il pannello dell'automobile e il pannello dei pulsanti.
     */
    public MainGUI() {
        super();
        concessionaria = new Concessionaria(); // Inizializza la concessionaria
        carPane = new CarPane(this); // Inizializza il pannello dell'automobile
        buttonPane = new ButtonPane(this); // Inizializza il pannello dei pulsanti

        // Aggiunge i pannelli alla finestra principale
        super.getChildren().addAll(carPane, buttonPane);

        // Imposta i vincoli per il layout dei pannelli
        AnchorPane.setTopAnchor(carPane, 0.0);
        AnchorPane.setLeftAnchor(carPane, 0.0);
        AnchorPane.setBottomAnchor(buttonPane, 0.0);
        AnchorPane.setRightAnchor(buttonPane, 0.0);
    }

    /**
     * Restituisce la concessionaria di automobili associata a MainGUI.
     *
     * @return La concessionaria di automobili
     */
    public Concessionaria getConcessionaria() {
        return concessionaria;
    }

    /**
     * Restituisce il pannello per visualizzare le informazioni dell'automobile corrente.
     *
     * @return Il pannello dell'automobile
     */
    public CarPane getCarPane() {
        return carPane;
    }

    /**
     * Restituisce l'indice generale per l'automobile corrente.
     *
     * @return L'indice generale
     */
    public static int getGeneralIndex() {
        return GENERAL_INDEX;
    }

    /**
     * Resetta l'indice generale per l'automobile corrente.
     */
    public void resetIndiceGenerale() {
        GENERAL_INDEX = 0;
    }

    /**
     * Incrementa l'indice generale per l'automobile corrente.
     */
    public void incrementaIndiceGenerale(){
        GENERAL_INDEX++;
    }

    /**
     * Decrementa l'indice generale per l'automobile corrente.
     */
    public void decrementaIndiceGenerale(){
        GENERAL_INDEX--;
    }
}
