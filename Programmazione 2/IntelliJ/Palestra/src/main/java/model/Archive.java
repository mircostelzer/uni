package model;

import model.enums.AthleteRelevance;
import model.enums.Degree;
import model.interfaces.AthleteInterface;
import model.interfaces.PersonInterface;
import model.interfaces.StudentInterface;
import model.people.Athlete;
import model.people.AthleteStudent;
import model.people.Person;
import model.people.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class Archive {
    public static final double TARIFFA_BASE = 1000;
    private ArrayList<PersonInterface> people;
    private ArrayList<PersonInterface> currentShowing;
    private Comparator<PersonInterface> comparator;

    public Archive() {
        people = new ArrayList<>();
        currentShowing = new ArrayList<>();
        people.add(new Student("Bianchi Anna", 4, 1990, "UNIPD", Degree.LM));
        people.add(new Student("Bianchi Giovanni", 3, 1995, "UNITN", Degree.LT));
        people.add(new AthleteStudent("Ferrari Alberto", 7, 1993, "UNITN", Degree.LM, "Atletica", AthleteRelevance.Internazionale));
        people.add(new AthleteStudent("Ferrari Vincenzo", 8, 1997, "UNIVR", Degree.LT, "Atletica", AthleteRelevance.Nazionale));
        people.add(new Person("Rossi Carla", 2, 1990));
        people.add(new Person("Rossi Mario", 1, 1950));
        people.add(new Athlete("Verdi Alice", 6, 1967, "Curling", AthleteRelevance.Internazionale));
        people.add(new Athlete("Verdi Giacomo", 5, 1991, "Nuoto", AthleteRelevance.Nazionale));
        this.comparator = new NameComparator();
        this.showAll();
        currentShowing.sort(comparator);
    }

    public ArrayList<PersonInterface> getShowingList() {
        return currentShowing;
    }

    public Comparator<PersonInterface> getComparator() {
        return comparator;
    }

    public void toggleComparator() {
        if (comparator instanceof AgeComparator) {
            comparator = new NameComparator();
        } else {
            comparator = new AgeComparator();
        }
        currentShowing.sort(comparator);
    }

    public void showAll() {
        currentShowing.clear();
        currentShowing.addAll(people);
        currentShowing.sort(comparator);
    }

    public void filteredStudents() {
        currentShowing.clear();
        for (PersonInterface person : people) {
            if (person instanceof StudentInterface) {
                currentShowing.add(person);
            }
        }
    }

    public void filteredAthletes() {
        currentShowing.clear();
        for (PersonInterface person : people) {
            if (person instanceof AthleteInterface) {
                currentShowing.add(person);
            }
        }
    }
}
