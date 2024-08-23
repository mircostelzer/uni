package model.quests;

import model.Geralt;
import model.exceptions.LowLevelException;
import model.exceptions.MissingPrevQuestException;
import model.exceptions.MissingQuestException;

public abstract class Main_DLCQuest extends AbstractQuest{
    protected String place;
    private Main_DLCQuest prevQuest;
    protected Main_DLCQuest nextQuest;

    public Main_DLCQuest(String name, int minLvl, QuestType questType, String place, Main_DLCQuest prevQuest) {
        super(name, minLvl, questType, 10);
        this.place = place;
        this.prevQuest = prevQuest;
    }

    @Override
    public void complete(Geralt geralt) throws LowLevelException, MissingQuestException {
        if (geralt.getLevel() < minLvl) {
            throw new LowLevelException();
        }
        if (prevQuest == null || prevQuest.isCompleted()) {
            geralt.setLevel(geralt.getLevel() + 1);
            geralt.setGold(geralt.getGold() + reward);
            this.isCompleted = true;
        } else {
            throw new MissingPrevQuestException();
        }
    }


    public String prevQuestName() {
        if (prevQuest == null) {
            return "none";
        }
        return prevQuest.getName();
    }

    public void setNextQuest(Main_DLCQuest nextQuest) {
        this.nextQuest = nextQuest;
    }
}
