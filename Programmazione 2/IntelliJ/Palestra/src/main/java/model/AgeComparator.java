package model;

import model.interfaces.PersonInterface;

import java.util.Comparator;

public class AgeComparator implements Comparator<PersonInterface> {

    @Override
    public int compare(PersonInterface o1, PersonInterface o2) {
        return o1.getBirthYear() - o2.getBirthYear();
    }
}
