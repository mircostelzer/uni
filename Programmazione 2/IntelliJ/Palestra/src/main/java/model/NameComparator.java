package model;

import model.interfaces.PersonInterface;

import java.util.Comparator;

public class NameComparator implements Comparator<PersonInterface> {

    @Override
    public int compare(PersonInterface o1, PersonInterface o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
