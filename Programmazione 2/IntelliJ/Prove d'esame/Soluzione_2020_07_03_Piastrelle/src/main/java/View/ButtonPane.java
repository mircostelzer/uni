package View;

import Controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * La classe ButtonPane rappresenta un pannello di pulsanti per la navigazione.
 * Contiene i pulsanti "prev" e "next" per spostarsi tra diversi elementi.
 */
public class ButtonPane extends HBox {
    private Button prev;
    private Button next;

    /**
     * Costruttore della classe ButtonPane.
     * Inizializza i pulsanti e imposta le azioni dei pulsanti.
     *
     * @param mg Riferimento all'oggetto MainGUI per aggiornare l'interfaccia utente.
     */
    public ButtonPane(MainGUI mg) {
        super();
        prev = new Button("<prev");
        next = new Button("next>");
        prev.setDisable(true);

        setPrevAction(mg);
        setNextAction(mg);

        super.getChildren().addAll(prev, next);
    }

    /**
     * Imposta l'azione del pulsante "prev" per decrementare l'indice generale.
     *
     * @param mg Riferimento all'oggetto MainGUI per aggiornare l'interfaccia utente.
     */
    private void setPrevAction(MainGUI mg) {
        prev.setOnAction(event -> {
            MainGUI.decrementGeneralIndex();
            aggiornaTutto(mg);

            if (MainGUI.getGeneralIndex() == 0)
                prev.setDisable(true);
            else if (MainGUI.getGeneralIndex() < 5)
                next.setDisable(false);
        });
    }

    /**
     * Imposta l'azione del pulsante "next" per incrementare l'indice generale.
     *
     * @param mg Riferimento all'oggetto MainGUI per aggiornare l'interfaccia utente.
     */
    private void setNextAction(MainGUI mg) {
        next.setOnAction(event -> {
            MainGUI.incrementGeneralIndex();
            aggiornaTutto(mg);

            if (MainGUI.getGeneralIndex() == 5)
                next.setDisable(true);
            else if (MainGUI.getGeneralIndex() > 0)
                prev.setDisable(false);
        });
    }

    /**
     * Aggiorna l'interfaccia utente chiamando i metodi di aggiornamento dell'oggetto MainGUI.
     *
     * @param mg Riferimento all'oggetto MainGUI per aggiornare l'interfaccia utente.
     */
    private void aggiornaTutto(MainGUI mg) {
        mg.getTestoPane().aggiornaTesto();
        mg.getPiastrellaCorrente().aggiornaPiastrellaMostrata();
    }
}
