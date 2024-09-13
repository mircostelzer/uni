package model.quests.actual;

import model.Geralt;
import model.exceptions.LowLevelException;
import model.exceptions.MissingQuestException;
import model.quests.AbstractQuest;
import model.quests.QuestType;

import java.util.List;

public class ContractQuest extends AbstractQuest{
    private String monsters;

    public ContractQuest(String name, int minLvl, int reward, String monsters) {
        super(name, minLvl, QuestType.Contract, reward);
        this.monsters = monsters;
    }

    @Override
    public void complete(Geralt geralt) throws LowLevelException {
        if (geralt.getLevel() < minLvl) {
            throw new LowLevelException();
        }
        geralt.setLevel(geralt.getLevel() + 1);
        geralt.setGold(geralt.getGold() + (int)(reward*1.2));
        this.isCompleted = true;
    }

    public String toString() {
        return super.toString() + "\n" + "Mostri: [" + monsters + "]";
    }
}
