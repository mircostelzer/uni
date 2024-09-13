package View;

import Model.geralt.Geralt;
import Model.geralt.Mutation;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import java.util.ArrayList;

/**
 * Classe per visualizzare il pannello delle mutazioni di Geralt.
 */
public class MutationsPane extends VBox {
    private Text slotFisici;
    private Text slotMagie;
    private Text slotTol;
    private Text slotLibero;

    /**
     * Costruttore per creare il pannello delle mutazioni.
     *
     * @param geralt Il personaggio Geralt di cui visualizzare le mutazioni.
     */
    public MutationsPane(Geralt geralt) {
        super();
        creaTesti(geralt);
    }

    /**
     * Crea e aggiorna i testi delle mutazioni di Geralt.
     *
     * @param geralt Il personaggio Geralt di cui aggiornare le mutazioni.
     */
    public void creaTesti(Geralt geralt) {
        super.getChildren().clear();
        ArrayList<Mutation> al = geralt.getMutations();

        slotFisici = new Text(al.get(0).toString());
        slotFisici.setFill(Color.CRIMSON);

        slotMagie = new Text(al.get(1).toString());
        slotMagie.setFill(Color.CADETBLUE);

        slotTol = new Text(al.get(2).toString());
        slotTol.setFill(Color.CHARTREUSE);

        slotLibero = new Text(al.get(3).toString());
        slotLibero.setFill(Color.ORANGE);
        aggiungiMutazioni();
    }

    /**
     * Aggiunge i testi delle mutazioni al pannello.
     */
    private void aggiungiMutazioni() {
        super.getChildren().add(new Text("Mutations: "));
        super.getChildren().add(slotFisici);
        super.getChildren().add(slotMagie);
        super.getChildren().add(slotTol);
        super.getChildren().add(slotLibero);
    }
}