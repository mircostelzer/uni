package View;

import Model.Palestra;
import javafx.scene.text.Text;

/**
 * Classe che rappresenta il pannello centrale dell'interfaccia grafica.
 * Estende la classe javafx.scene.text.Text.
 */
public class CentralPane extends Text {
    /**
     * Costruttore della classe CentralPane.
     * Imposta il testo iniziale del pannello con la rappresentazione testuale di tutte le persone nella palestra.
     *
     * @param p Oggetto Palestra contenente le informazioni sulle persone.
     */
    public CentralPane(Palestra p) {
        super(p.stampa(p.getPersone()));
    }

    /**
     * Metodo per aggiornare il testo nel pannello centrale.
     *
     * @param s Stringa da impostare come nuovo testo nel pannello.
     */
    public void aggiornaTesto(String s){
        super.setText(s);
    }
}
