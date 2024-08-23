package view;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.comparators.NameComparator;
import model.comparators.RewardComparator;
import model.quests.QuestInterface;
import model.quests.QuestType;

import java.util.ArrayList;
import java.util.List;

public class QuestColumn extends VBox {
    private List<QuestInterface> quests;
    private QuestType questType;
    private Button nameSort;
    private Button rewardSort;
    private Controller controller;

    public QuestColumn(List<QuestInterface> quests, QuestType questType, Controller controller) {
        this.quests = new ArrayList<>();
        this.questType = questType;
        this.controller = controller;
        for (QuestInterface quest : quests) {
            if (quest.getQuestType().equals(this.questType)) {
                this.quests.add(quest);
            }
        }
        this.setSpacing(5);
        this.setAlignment(Pos.TOP_CENTER);
        this.redraw();
    }

    public void redraw() {
        this.getChildren().clear();
        for (QuestInterface quest : quests) {
            this.getChildren().add(new QuestPane(quest, controller));
        }
        nameSort = new Button("Ordina per Nome");
        setNameSort();
        rewardSort = new Button("Ordina per Ricompensa");
        setRewardSort();
        this.getChildren().addAll(nameSort, rewardSort);
    }

    private void setNameSort() {
        nameSort.setOnMouseClicked(e -> {
            controller.toggleComparator(this.questType, new NameComparator());
        });
    }

    private void setRewardSort() {
        rewardSort.setOnMouseClicked(e -> {
            controller.toggleComparator(this.questType, new RewardComparator());
        });
    }
}
