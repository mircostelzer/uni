package model.comparators;

import model.quests.QuestInterface;

import java.util.Comparator;

public class NameComparator implements Comparator<QuestInterface> {
    @Override
    public int compare(QuestInterface o1, QuestInterface o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
