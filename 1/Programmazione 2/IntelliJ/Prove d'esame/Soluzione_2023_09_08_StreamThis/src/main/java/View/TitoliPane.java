package View;

import Controller.MainGUI;
import Model.AlertDisplayer;
import Model.Titoli.Anime;
import Model.Titoli.Film;
import Model.Titoli.Serie;
import Model.Titolo;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Questa classe rappresenta un pannello che mostra i titoli disponibili.
 */
public class TitoliPane extends HBox {
    private MainGUI mg;

    /**
     * Costruisce una nuova istanza di TitoliPane.
     *
     * @param mg L'istanza di MainGUI utilizzata per gestire il pannello.
     */
    public TitoliPane(MainGUI mg) {
        super();
        this.mg = mg;
        aggiornaTitoliPane();
    }

    /**
     * Aggiorna il pannello dei titoli con i dati attuali.
     */
    public void aggiornaTitoliPane() {
        getChildren().clear();
        ArrayList<Titolo> titoli = mg.getTitoliDB().getArchivio();
        for (int i = MainGUI.getGeneralIndex(); i < MainGUI.getGeneralIndex() + 3; i++) {
            getChildren().add(creaRettangolo(titoli.get(i)));
        }
    }

    /**
     * Crea un rettangolo per visualizzare un titolo.
     *
     * @param t Il titolo da visualizzare.
     * @return Un StackPane contenente il rettangolo e il testo del titolo.
     */
    private StackPane creaRettangolo(Titolo t) {
        Rectangle r = new Rectangle(130, 40);
        r.setFill(getColore(t));
        String ultimeDueCifre = t.getAnno().substring(2);
        Text text = new Text(t.getTitolo() + " ('" + ultimeDueCifre + ")");
        StackPane sp = new StackPane(r, text);
        impostaTitoloAction(sp, t);
        return sp;
    }

    /**
     * Restituisce il colore associato al tipo di titolo.
     *
     * @param t Il titolo.
     * @return Il colore associato al tipo di titolo.
     */
    private Color getColore(Titolo t) {
        if (t instanceof Anime)
            return Color.SALMON;
        else if (t instanceof Film)
            return Color.CYAN;
        else if (t instanceof Serie)
            return Color.MAGENTA;
        return null;
    }

    /**
     * Imposta l'azione per un titolo quando viene cliccato.
     *
     * @param sp Lo StackPane che contiene il titolo.
     * @param t Il titolo.
     */
    private void impostaTitoloAction(StackPane sp, Titolo t) {
        sp.setOnMouseClicked(mouseEvent -> {
            VBox centro = creaCentro(t);
            centro.setAlignment(Pos.CENTER);
            mg.setCenter(centro);
        });
    }

    /**
     * Crea un pannello centrale per visualizzare i dettagli di un titolo.
     *
     * @param t Il titolo.
     * @return Un VBox contenente i dettagli del titolo.
     */
    private VBox creaCentro(Titolo t) {
        VBox vb = new VBox();
        Text text = new Text(t.toString());
        vb.getChildren().add(text);
        Button b = new Button("Acquista " + t.getPrezzoScontato() + "€");
        if (t instanceof Serie s) {
            HBox hb = new HBox();
            for (int i = 0; i < s.getnStagioni(); i++) {
                Button butt = new Button("S" + i);
                setSerieButtonAction(butt, b, s);
                hb.getChildren().add(butt);
            }
            hb.setAlignment(Pos.CENTER);
            vb.getChildren().add(hb);
        }
        b.setPrefSize(110, 10);
        b.setOnAction(event -> AlertDisplayer.display_ERROR_Alert("ERRORE: connessione non presente."));
        vb.getChildren().add(b);
        return vb;
    }

    /**
     * Imposta l'azione per i bottoni delle stagioni di una serie.
     *
     * @param b Il bottone della stagione.
     * @param bottoneAcquista Il bottone per acquistare.
     * @param s La serie.
     */
    private void setSerieButtonAction(Button b, Button bottoneAcquista, Serie s) {
        b.setOnAction(event -> {
            b.setDisable(true);
            s.incrementaStagioniSelezionate();
            s.scontoStagioni();
            bottoneAcquista.setText("Acquista " + s.getPrezzoScontato() + "€");
        });
    }
}
