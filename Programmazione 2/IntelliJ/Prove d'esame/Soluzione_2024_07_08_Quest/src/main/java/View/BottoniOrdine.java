package View;

import Controller.MainGUI;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class BottoniOrdine extends VBox {
    private Button nome;
    private Button ricompensa;
    private ListaQuest listaQuest;

    /**
     * crea il vbox che contiene i bottoni per ordinare
     * imposta lo spazio tra bottoni a 5
     * @param listaQuest
     */
    public BottoniOrdine(ListaQuest listaQuest) {
        this.listaQuest = listaQuest;
        nome = new Button("Ordina per Nome");
        ricompensa = new Button("Ordina per Ricompensa");

        setNomeAction();
        setRicompensaAction();

        getChildren().addAll(nome, ricompensa);
        setSpacing(5);

        setAlignment(Pos.CENTER);
    }

    /**
     * attiva l'azione del bottone ricompensa
     * ordina la lista in base alla ricompensa e crea la vista delle relative quest
     */
    private void setRicompensaAction() {
        ricompensa.setOnAction(event -> {
            MainGUI.getQuestDB().sortByRicompensa(listaQuest.getCollection());
            listaQuest.creaLista();
        });
    }

    /**
     * attiva l'azione del bottone nome
     * ordina la lista in base al nome e crea la vista delle relative quest
     */
    private void setNomeAction() {
        nome.setOnAction(event -> {
            MainGUI.getQuestDB().sortByNome(listaQuest.getCollection());
            listaQuest.creaLista();
        });
    }
}
