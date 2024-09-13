package model.comparators;

import model.quests.Quest;
import java.util.Comparator;

public class QuestByRicompensaComparator implements Comparator<Quest> {
    @Override
    public int compare(Quest o1, Quest o2) {
        if (o1.getRicompensa() == o2.getRicompensa()){
            return new QuestByNameComparator().compare(o1,o2);
        }
        if (o1.getRicompensa() < o2.getRicompensa()){
            return 1;
        }
        return -1;
    }

}
