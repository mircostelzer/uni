package model.quests;

import model.Geralt;
import model.exceptions.LowLevelException;
import model.exceptions.MissingQuestException;

public abstract class AbstractQuest implements QuestInterface{
    private String name;
    protected int minLvl;
    private QuestType questType;
    protected int reward;
    protected boolean isCompleted;

    public AbstractQuest(String name, int minLvl, QuestType questType, int reward) {
        this.name = name;
        this.minLvl = minLvl;
        this.questType = questType;
        this.reward = reward;
        this.isCompleted = false;
    }


    public int getMinLvl() {
        return minLvl;
    }

    public void setMinLvl(int minLvl) {
        this.minLvl = minLvl;
    }

    public QuestType getQuestType() {
        return questType;
    }

    public void setQuestType(QuestType questType) {
        this.questType = questType;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String toString() {
        return name + " (" + reward + ")";
    }
}
