package Controller;

import Model.Evocazione.Evocazione;
import Model.Gioco;
import javafx.scene.layout.AnchorPane;

/**
 * La classe MainGUI estende AnchorPane e gestisce la logica principale dell'interfaccia utente del gioco.
 */
public class MainGUI extends AnchorPane {
    private static boolean turno;
    private Gioco gioco;
    private GiocatoreEnhanced giocatore1;
    private GiocatoreEnhanced giocatore2;

    /**
     * Costruttore per creare una nuova istanza di MainGUI.
     * Inizializza il gioco, i giocatori e imposta l'interfaccia utente.
     */
    public MainGUI() {
        super();
        turno = true;
        gioco = new Gioco();
        giocatore1 = new GiocatoreEnhanced(gioco.getG1(), this);
        giocatore2 = new GiocatoreEnhanced(gioco.getG2(), this);

        invertiGiocatori();
    }

    /**
     * Cambia il turno del gioco.
     */
    public static void cambiaTurno() {
        MainGUI.turno = !MainGUI.turno;
    }

    /**
     * Verifica se è il turno del primo giocatore.
     *
     * @return true se è il turno del primo giocatore, altrimenti false.
     */
    public static boolean isTurno() {
        return turno;
    }

    /**
     * Restituisce l'evocazione del giocatore corrente che sta attaccando.
     *
     * @return L'evocazione che sta attaccando, o null se nessuna evocazione sta attaccando.
     */
    public Evocazione getDisabled() {
        GiocatoreEnhanced giocatoreEnhanced = isTurno() ? giocatore1 : giocatore2;
        for (Evocazione evocazione : giocatoreEnhanced.getGiocatore().getEvocazioni()) {
            if (evocazione.isAttacking()) {
                return evocazione;
            }
        }
        return null;
    }

    /**
     * Restituisce il giocatore avversario.
     *
     * @return Il giocatore avversario.
     */
    public GiocatoreEnhanced getAltroGiocatore() {
        return !isTurno() ? giocatore1 : giocatore2;
    }

    /**
     * Inverte i giocatori nell'interfaccia utente, posizionando gli elementi grafici dei giocatori appropriati.
     */
    public void invertiGiocatori() {
        getChildren().clear();
        getChildren().addAll(giocatore1.getEvocazioniGiocatore(), giocatore2.getEvocazioniGiocatore(), giocatore1.getEnergieGiocatore(), giocatore2.getEnergieGiocatore());
        AnchorPane.clearConstraints(giocatore1.getEvocazioniGiocatore());
        AnchorPane.clearConstraints(giocatore1.getEnergieGiocatore());
        AnchorPane.clearConstraints(giocatore2.getEvocazioniGiocatore());
        AnchorPane.clearConstraints(giocatore2.getEnergieGiocatore());

        if (turno) {
            AnchorPane.setTopAnchor(giocatore2.getEvocazioniGiocatore(), 0.0);
            AnchorPane.setRightAnchor(giocatore2.getEvocazioniGiocatore(), 0.0);

            AnchorPane.setBottomAnchor(giocatore1.getEvocazioniGiocatore(), 0.0);
            AnchorPane.setLeftAnchor(giocatore1.getEvocazioniGiocatore(), 0.0);

            AnchorPane.setTopAnchor(giocatore2.getEnergieGiocatore(), 200.0);
            AnchorPane.setRightAnchor(giocatore2.getEnergieGiocatore(), 0.0);

            AnchorPane.setTopAnchor(giocatore1.getEnergieGiocatore(), 200.0);
            AnchorPane.setLeftAnchor(giocatore1.getEnergieGiocatore(), 0.0);
        } else {
            AnchorPane.setTopAnchor(giocatore1.getEvocazioniGiocatore(), 0.0);
            AnchorPane.setRightAnchor(giocatore1.getEvocazioniGiocatore(), 0.0);

            AnchorPane.setBottomAnchor(giocatore2.getEvocazioniGiocatore(), 0.0);
            AnchorPane.setLeftAnchor(giocatore2.getEvocazioniGiocatore(), 0.0);

            AnchorPane.setTopAnchor(giocatore1.getEnergieGiocatore(), 200.0);
            AnchorPane.setRightAnchor(giocatore1.getEnergieGiocatore(), 0.0);

            AnchorPane.setTopAnchor(giocatore2.getEnergieGiocatore(), 200.0);
            AnchorPane.setLeftAnchor(giocatore2.getEnergieGiocatore(), 0.0);
        }
    }
}
