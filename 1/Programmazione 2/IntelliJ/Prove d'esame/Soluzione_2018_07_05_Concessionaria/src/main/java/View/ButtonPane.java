package View;

import Controller.MainGUI;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * La classe ButtonPane rappresenta un pannello contenente pulsanti per navigare tra le automobili e cambiare il criterio di ordinamento.
 * Fornisce pulsanti per navigare avanti e indietro tra le automobili e per cambiare il criterio di ordinamento delle automobili.
 */
public class ButtonPane extends HBox {
    private Button avanti; // Pulsante per passare alla prossima automobile
    private Button indietro; // Pulsante per tornare alla precedente automobile
    private Button changeSort; // Pulsante per cambiare il criterio di ordinamento delle automobili

    /**
     * Costruttore per la classe ButtonPane.
     * Crea una nuova istanza di ButtonPane e inizializza i pulsanti per la navigazione e il cambio di ordinamento.
     *
     * @param mg MainGUI associata al pannello dei pulsanti
     */
    public ButtonPane(MainGUI mg) {
        super();

        avanti = new Button(">"); // Pulsante per passare alla prossima automobile
        indietro = new Button("<"); // Pulsante per tornare alla precedente automobile
        changeSort = new Button("id"); // Pulsante per cambiare il criterio di ordinamento delle automobili

        indietro.setDisable(true); // Disabilita il pulsante Indietro all'inizio

        setIndietroAction(mg); // Imposta l'azione per il pulsante Indietro
        setAvantiAction(mg); // Imposta l'azione per il pulsante Avanti
        setChangeSortAction(mg); // Imposta l'azione per il pulsante Cambia Ordinamento

        super.getChildren().addAll(changeSort, indietro, avanti); // Aggiunge i pulsanti al pannello
    }

    /**
     * Imposta l'azione per il pulsante Indietro.
     * Quando il pulsante viene premuto, diminuisce l'indice generale delle automobili visualizzate e aggiorna il testo nell'interfaccia utente.
     *
     * @param mg MainGUI associata al pannello dei pulsanti
     */
    private void setIndietroAction(MainGUI mg){
        indietro.setOnAction(event -> {
            mg.decrementaIndiceGenerale(); // Decrementa l'indice generale delle automobili
            mg.getCarPane().updateText(mg); // Aggiorna il testo nell'interfaccia utente

            // Abilita il pulsante Avanti se era disabilitato e disabilita il pulsante Indietro se l'indice generale è 0
            if(avanti.isDisabled())
                avanti.setDisable(false);
            if(MainGUI.getGeneralIndex() == 0)
                indietro.setDisable(true);
        });
    }

    /**
     * Imposta l'azione per il pulsante Avanti.
     * Quando il pulsante viene premuto, aumenta l'indice generale delle automobili visualizzate e aggiorna il testo nell'interfaccia utente.
     *
     * @param mg MainGUI associata al pannello dei pulsanti
     */
    private void setAvantiAction(MainGUI mg){
        avanti.setOnAction(event -> {
            mg.incrementaIndiceGenerale(); // Incrementa l'indice generale delle automobili
            mg.getCarPane().updateText(mg); // Aggiorna il testo nell'interfaccia utente

            // Abilita il pulsante Indietro se era disabilitato e disabilita il pulsante Avanti se l'indice generale è 8
            if(indietro.isDisabled())
                indietro.setDisable(false);
            if(MainGUI.getGeneralIndex() == 8)
                avanti.setDisable(true);
        });
    }

    /**
     * Imposta l'azione per il pulsante Cambia Ordinamento.
     * Quando il pulsante viene premuto, cambia il criterio di ordinamento delle automobili e aggiorna il testo nell'interfaccia utente.
     *
     * @param mg MainGUI associata al pannello dei pulsanti
     */
    private void setChangeSortAction(MainGUI mg){
        changeSort.setOnAction(event -> {
            mg.getConcessionaria().sortAutomobili(); // Ordina le automobili
            mg.resetIndiceGenerale(); // Resetta l'indice generale delle automobili
            mg.getCarPane().updateText(mg); // Aggiorna il testo nell'interfaccia utente

            // Disabilita il pulsante Indietro e abilita il pulsante Avanti
            indietro.setDisable(true);
            avanti.setDisable(false);

            // Aggiorna il testo del pulsante Cambia Ordinamento in base al criterio di ordinamento attuale
            if(mg.getConcessionaria().isSortedByID())
                changeSort.setText("mese");
            else
                changeSort.setText("id");
        });
    }
}
