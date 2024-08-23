package model.quests.actual;

import model.Geralt;
import model.exceptions.LowLevelException;
import model.exceptions.MissingQuestException;
import model.quests.AbstractQuest;
import model.quests.QuestType;

public class SecondaryQuest extends AbstractQuest {
    private String npc;

    public SecondaryQuest(String name, int minLvl, int reward, String npc) {
        super(name, minLvl, QuestType.Secondary, reward);
        this.npc = npc;
    }

    @Override
    public void complete(Geralt geralt) throws LowLevelException {
        if (geralt.getLevel() < minLvl) {
            throw new LowLevelException();
        }
        geralt.setLevel(geralt.getLevel() + 2);
        geralt.setGold(geralt.getGold() + reward);
        this.isCompleted = true;
    }

    public String toString() {
        return super.toString() + "\n" + "NPC: " + npc;
    }
}
