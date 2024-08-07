package View;

import Controller.MainGUI;
import Model.Auto;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * La classe CarPane rappresenta un pannello di testo che visualizza le informazioni di un'automobile.
 * Aggiorna il testo con le informazioni dell'automobile corrente ogni volta che viene richiamato il metodo updateText.
 */
public class CarPane extends Text {

    /**
     * Costruttore per la classe CarPane.
     * Crea una nuova istanza di CarPane e aggiorna il testo con le informazioni dell'automobile corrente.
     *
     * @param mg MainGUI associata al pannello dell'automobile
     */
    public CarPane(MainGUI mg) {
        super();
        updateText(mg); // Aggiorna il testo con le informazioni dell'automobile corrente
    }

    /**
     * Aggiorna il testo del pannello con le informazioni dell'automobile corrente.
     *
     * @param mg MainGUI associata al pannello dell'automobile
     */
    public void updateText(MainGUI mg){
        ArrayList<Auto> automobili = mg.getConcessionaria().getAutomobili(); // Ottiene la lista delle automobili dalla concessionaria
        super.setText(automobili.get(MainGUI.getGeneralIndex()).toString()); // Imposta il testo con le informazioni dell'automobile corrente
    }
}
