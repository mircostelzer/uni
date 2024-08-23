package model.quests;

import model.Geralt;
import model.exceptions.LowLevelException;
import model.exceptions.MissingQuestException;

public interface QuestInterface {
    void complete(Geralt geralt) throws LowLevelException, MissingQuestException;
    String toString();
    boolean isCompleted();
    QuestType getQuestType();
    String getName();
    int getReward();
    int getMinLvl();
}
