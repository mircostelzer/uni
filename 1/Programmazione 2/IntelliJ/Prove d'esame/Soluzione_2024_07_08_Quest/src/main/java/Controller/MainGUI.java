package Controller;

import Model.Geraldo;
import Model.QuestDB;
import View.ListaQuest;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * permette di gestire tutta l'interfaccia grafica, comunicando con Model e con View
 */
public class MainGUI extends AnchorPane {
    private static Geraldo geraldo;
    private static QuestDB questDB;
    private static Text geraldoStats;

    /**
     * crea la parte grafica
     * aggiunge e posiziona le statistiche di Geraldo e le 4 liste di quest
     */
    public MainGUI() {
        geraldo = new Geraldo();
        questDB = new QuestDB();
        geraldoStats = new Text(geraldo.toString());

        ListaQuest mainQuests = new ListaQuest(questDB.getMainQuests());
        ListaQuest secondary = new ListaQuest(questDB.getSecondaryQuests());
        ListaQuest contract = new ListaQuest(questDB.getContractQuests());
        ListaQuest dlc = new ListaQuest(questDB.getDlcQuests());

        HBox hb = new HBox(mainQuests, secondary, contract, dlc);
        hb.setSpacing(10);

        getChildren().addAll(geraldoStats, hb);

        AnchorPane.setTopAnchor(geraldoStats, 0.0);
        AnchorPane.setLeftAnchor(geraldoStats, 0.0);

        AnchorPane.setTopAnchor(hb, 20.0);
        AnchorPane.setLeftAnchor(hb, 0.0);
    }

    /**
     * aggiorna la vista delle stats di Geraldo
     */
    public static void aggiornaGeraldoStats(){
        geraldoStats.setText(geraldo.toString());
    }

    public static Geraldo getGeraldo() {
        return geraldo;
    }

    public static QuestDB getQuestDB() {
        return questDB;
    }
}

