package model.quests.actual;

import model.quests.Main_DLCQuest;
import model.quests.QuestType;

public class MainQuest extends Main_DLCQuest {

    public MainQuest(String name, int minLvl, String place, MainQuest prevQuest) {
        super(name, minLvl, QuestType.Main, place, prevQuest);
    }

    public String toString() {
        return super.toString() + "\n" + "Luogo: " + place + "\n" + "Req: " + this.prevQuestName();
    }

}
