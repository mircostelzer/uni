package model.comparators;

import model.quests.QuestInterface;

import java.util.Comparator;

public class RewardComparator implements Comparator<QuestInterface> {
    @Override
    public int compare(QuestInterface o1, QuestInterface o2) {
        if (o1.getReward() == o2.getReward()) {
            return o1.getName().compareTo(o2.getName());
        }
        return o1.getReward() - o2.getReward();
    }
}
