package model.quests.actual;

import model.quests.QuestType;

import java.util.List;

public class TreasureHunt extends ContractQuest{
    private String place;

    public TreasureHunt(String name, int minLvl, int reward, String monsters, String place) {
        super(name, minLvl, reward, monsters);
        this.place = place;
    }

    public String toString() {
        return super.toString() + "\n" + "Luogo: " + place;
    }
}
