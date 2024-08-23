package controller;

import javafx.scene.control.Alert;
import model.Geralt;
import model.exceptions.LowLevelException;
import model.exceptions.MissingMainQuestException;
import model.exceptions.MissingPrevQuestException;
import model.exceptions.MissingQuestException;
import model.quests.Main_DLCQuest;
import model.quests.QuestInterface;
import model.quests.QuestLog;
import model.quests.QuestType;
import model.quests.actual.DLCQuest;
import view.MainView;

import java.util.Comparator;

public class Controller {
    private Geralt geralt;
    private QuestLog questLog;
    private MainView mainView;

    public Controller(Geralt geralt, QuestLog questLog) {
        this.geralt = geralt;
        this.questLog = questLog;
        mainView = new MainView(geralt, questLog, this);
    }

    public void complete(QuestInterface quest) {
        try {
            quest.complete(geralt);
        } catch (LowLevelException lle) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You can't complete this quest yet");
            alert.setContentText("You need to be at least level " + quest.getMinLvl());
            alert.show();
        } catch (MissingMainQuestException mmq) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You can't complete this quest yet");
            alert.setContentText("You need to complete this quest: " + ((DLCQuest)quest).getMainQuestName());
            alert.show();
        } catch (MissingPrevQuestException mpq) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You can't complete this quest yet");
            alert.setContentText("You need to complete this quest: " + ((Main_DLCQuest)quest).prevQuestName());
            alert.show();
        } catch (MissingQuestException qe) {
            qe.printStackTrace();
        }
        mainView.redraw();
    }

    public void toggleComparator(QuestType questType, Comparator<QuestInterface> comparator) {
        questLog.toggleComparator(questType, comparator);
        mainView.redraw();
    }

    public MainView getMainView() {
        return mainView;
    }
}
