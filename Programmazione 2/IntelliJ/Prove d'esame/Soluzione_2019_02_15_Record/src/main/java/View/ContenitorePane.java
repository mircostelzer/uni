package View;

import Model.ListaRecord;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * La classe ContenitorePane estende AnchorPane e rappresenta un pannello che contiene una lista di record e pulsanti associati per manipolarla.
 */
public class ContenitorePane extends AnchorPane {

    private ListaRecordPane listaRecordPane;
    private ButtonPane buttonPane;
    private Button aggiungi;
    private Bottoni bottoni;

    /**
     * Costruisce un nuovo oggetto ContenitorePane con una lista di record e pulsanti associati.
     *
     * @param listaRecord   La lista di record da visualizzare.
     * @param isAutoList    Indica se la lista è una lista di automobili (true) o di persone (false).
     */
    public ContenitorePane(ListaRecord listaRecord, boolean isAutoList) {
        super();
        listaRecordPane = new ListaRecordPane(listaRecord, isAutoList);
        bottoni = new Bottoni(listaRecordPane, isAutoList);
        buttonPane = new ButtonPane(bottoni, isAutoList);
        aggiungi = bottoni.getAggiungi();

        // Aggiunge i componenti al ContenitorePane
        super.getChildren().addAll(listaRecordPane, buttonPane, aggiungi);

        // Imposta i vincoli di posizionamento degli elementi all'interno del pannello
        AnchorPane.setTopAnchor(listaRecordPane, 0.0);
        AnchorPane.setLeftAnchor(listaRecordPane, 0.0);
        AnchorPane.setTopAnchor(buttonPane, 200.0);
        AnchorPane.setBottomAnchor(aggiungi, 0.0);

        // Posiziona il pulsante "Aggiungi" a sinistra o a destra in base al tipo di lista
        if (isAutoList) {
            AnchorPane.setLeftAnchor(aggiungi, 0.0);
            AnchorPane.setLeftAnchor(buttonPane, 0.0);
        } else {
            AnchorPane.setRightAnchor(aggiungi, 0.0);
            AnchorPane.setRightAnchor(buttonPane, 0.0);
        }
    }
}
