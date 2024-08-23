package view;

import controller.Controller;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.Geralt;
import model.quests.QuestInterface;
import model.quests.QuestLog;
import model.quests.QuestType;

import java.util.List;

public class MainView extends BorderPane {
    private Geralt geralt;
    private QuestLog questLog;
    private QuestColumn mainQuestsColumn;
    private QuestColumn secondaryQuestsColumn;
    private QuestColumn contractsColumn;
    private QuestColumn dlcColumn;
    private Text text;
    private HBox hBox;
    private Controller controller;

    public MainView(Geralt geralt, QuestLog questLog, Controller controller) {
        this.geralt = geralt;
        this.questLog = questLog;
        this.controller = controller;
        this.redraw();
    }

    public void redraw() {
        text = new Text(geralt.toString());
        text.setTextAlignment(TextAlignment.LEFT);
        this.setTop(text);

        hBox = new HBox();
        mainQuestsColumn = new QuestColumn(questLog.getMainQuests(), QuestType.Main, controller);
        secondaryQuestsColumn = new QuestColumn(questLog.getSecondaryQuests(), QuestType.Secondary, controller);
        contractsColumn = new QuestColumn(questLog.getContractQuests(), QuestType.Contract, controller);
        dlcColumn = new QuestColumn(questLog.getDLCQuests(), QuestType.DLC, controller);
        hBox.getChildren().addAll(mainQuestsColumn, secondaryQuestsColumn, contractsColumn, dlcColumn);
        hBox.setSpacing(10);
        this.setCenter(hBox);
    }
}
