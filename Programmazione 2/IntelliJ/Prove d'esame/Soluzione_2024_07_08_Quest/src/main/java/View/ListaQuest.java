package View;

import Model.Quest;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ListaQuest extends VBox {
    private ArrayList<Quest> collection;
    private BottoniOrdine bottiniOrdine;

    /**
     * crea la vista di una lista di quest
     * @param collection
     */
    public ListaQuest(ArrayList<Quest> collection) {
        this.collection = collection;
        bottiniOrdine = new BottoniOrdine(this);
        creaLista();
    }

    /**
     * crea la lista di quest
     * mette le quest in un vbox, che in fondo ha i bottoni per ordinare
     * imposta lo spazio tra quest a 5
     */
    public void creaLista() {
        getChildren().clear();
        for (Quest q : collection){
            getChildren().add(new QuestView(q));
        }
        getChildren().add(bottiniOrdine);
        setSpacing(5);
    }

    public ArrayList<Quest> getCollection() {
        return collection;
    }
}
