package model.comparators;

import model.quests.Quest;
import java.util.Comparator;

public class QuestByNameComparator implements Comparator<Quest> {
    @Override
    public int compare(Quest o1, Quest o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
