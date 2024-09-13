package model.quests.actual;

import model.Geralt;
import model.exceptions.LowLevelException;
import model.exceptions.MissingMainQuestException;
import model.exceptions.MissingQuestException;
import model.quests.Main_DLCQuest;
import model.quests.QuestType;

public class DLCQuest extends Main_DLCQuest {
    private MainQuest mainQuest;

    public DLCQuest(String name, int minLvl, String place, DLCQuest prevQuest, MainQuest mainQuest) {
        super(name, minLvl, QuestType.DLC, place, prevQuest);
        this.mainQuest = mainQuest;
    }

    @Override
    public void complete(Geralt geralt) throws LowLevelException, MissingQuestException {
        if (!mainQuest.isCompleted()) {
            throw new MissingMainQuestException();
        }
        super.complete(geralt);
    }

    public String toString() {
        return super.toString() + "\n" + "Req: " + mainQuest.getName();
    }

    public String getMainQuestName() {
        return mainQuest.getName();
    }
}
