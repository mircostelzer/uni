package model.people;

import model.AgeComparator;
import model.Archive;
import model.NameComparator;
import model.interfaces.PersonInterface;

import java.util.Comparator;

public class Person implements PersonInterface {
    private String name;
    private int birthYear;
    private int code;
    private double tariffa;

    public Person(String name,  int code, int birthYear) {
        this.name = name;
        this.code = code;
        this.birthYear = birthYear;
        this.applyDiscount();
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getCode() {
        return code;
    }

    public double getTariffa() {
        return tariffa;
    }

    protected void setTariffa(double tariffa) {
        this.tariffa = tariffa;
    }

    public String toString() {
        return getName() + " " + getCode() + " " + getBirthYear();
    }

    protected void applyDiscount() {
        if (birthYear < 1968) {
            this.setTariffa(Archive.TARIFFA_BASE*0.65);
        } else {
            this.setTariffa(Archive.TARIFFA_BASE);
        }
    }


}
