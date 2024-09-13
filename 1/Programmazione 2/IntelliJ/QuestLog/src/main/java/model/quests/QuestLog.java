package model.quests;

import model.comparators.NameComparator;
import model.quests.actual.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuestLog {
    private List<QuestInterface> mainQuests;
    private List<QuestInterface> secondaryQuests;
    private List<QuestInterface> contractQuests;
    private List<QuestInterface> DLCQuests;

    public QuestLog() {
        mainQuests = new ArrayList<>();
        secondaryQuests = new ArrayList<>();
        contractQuests = new ArrayList<>();
        DLCQuests = new ArrayList<>();


        MainQuest mq1 = new MainQuest("Lilac and Gooseberries", 2, "White Orchard", null);
        mainQuests.add(mq1);
        MainQuest mq2 = new MainQuest("The Nilfgaardian Connection", 3, "Velen", mq1);
        mq1.setNextQuest(mq2);
        mainQuests.add(mq2);
        MainQuest mq3 = new MainQuest("Pyres of Novigrad", 5, "Novigrad", mq2);
        mq2.setNextQuest(mq3);
        mq3.setNextQuest(null);
        mainQuests.add(mq3);

        SecondaryQuest sq1 = new SecondaryQuest("A Favor for a Friend", 2, 10, "Keira Mertz");
        secondaryQuests.add(sq1);
        SecondaryQuest sq2 = new SecondaryQuest("The Last Wish", 6, 30, "Bloody Baron");
        secondaryQuests.add(sq2);
        ContractQuest c1 = new ContractQuest("Swamp Thing", 12, 40, "Drowners, Foglet" );
        contractQuests.add(c1);
        TreasureHunt th1 = new TreasureHunt("Coast of Wrecks", 4, 50, "Drowners", "Velen");
        contractQuests.add(th1);
        TreasureHunt th2 = new TreasureHunt("Dirty Funds", 1, 20, "Wolves, Drowners", "Velen");
        contractQuests.add(th2);
        DLCQuest dlc1 = new DLCQuest("Envoys, Wineboys", 8, "Velen", null, mq2);
        DLCQuests.add(dlc1);
        DLCQuest dlc2 = new DLCQuest("Capture the Castle", 9, "Toussaint", dlc1, mq2);
        dlc1.setNextQuest(dlc2);
        dlc2.setNextQuest(null);
        DLCQuests.add(dlc2);
    }

    public void toggleComparator(QuestType questType, Comparator<QuestInterface> comparator) {
        switch (questType) {
            case Main -> mainQuests.sort(comparator);
            case Secondary -> secondaryQuests.sort(comparator);
            case Contract -> contractQuests.sort(comparator);
            case DLC -> DLCQuests.sort(comparator);
        }
    }

    public List<QuestInterface> getMainQuests() {
        return mainQuests;
    }

    public List<QuestInterface> getSecondaryQuests() {
        return secondaryQuests;
    }

    public List<QuestInterface> getContractQuests() {
        return contractQuests;
    }

    public List<QuestInterface> getDLCQuests() {
        return DLCQuests;
    }
}
