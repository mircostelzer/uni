package View;

import Model.ListaRecord;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * La classe ListaRecordPane estende StackPane e rappresenta un pannello che visualizza una lista di record.
 */
public class ListaRecordPane extends StackPane {

    private ListaRecord listaRecord;
    private boolean isAutoList;

    private Rectangle rectangle;
    private Text testo;

    /**
     * Costruisce un nuovo oggetto ListaRecordPane con una lista di record e un indicatore del tipo di lista.
     *
     * @param listaRecord   La lista di record da visualizzare.
     * @param isAutoList    Indica se la lista è una lista di automobili (true) o di persone (false).
     */
    public ListaRecordPane(ListaRecord listaRecord, boolean isAutoList) {
        super();
        this.listaRecord = listaRecord;
        this.isAutoList = isAutoList;

        // Crea il rettangolo per il background e il testo per visualizzare la lista di record
        rectangle = new Rectangle(400, 200);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.GREY);
        testo = new Text();

        // Crea un VBox per posizionare il testo nella parte superiore sinistra del pannello
        VBox vBox = new VBox();
        vBox.getChildren().addAll(testo);
        vBox.setAlignment(Pos.TOP_LEFT);

        // Aggiunge il rettangolo e il VBox al ListaRecordPane
        super.getChildren().addAll(rectangle, vBox);
    }

    /**
     * Restituisce true se la lista è una lista di automobili, altrimenti false.
     *
     * @return true se la lista è una lista di automobili, altrimenti false.
     */
    public boolean isAutoList() {
        return isAutoList;
    }

    /**
     * Restituisce la lista di record.
     *
     * @return La lista di record.
     */
    public ListaRecord getListaRecord() {
        return listaRecord;
    }

    /**
     * Aggiorna il testo visualizzato nel pannello con la rappresentazione testuale della lista di record.
     */
    public void aggiornaTestoLista() {
        testo.setText(listaRecord.toString());
    }
}
