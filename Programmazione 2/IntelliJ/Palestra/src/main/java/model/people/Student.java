package model.people;

import model.Archive;
import model.enums.Degree;
import model.interfaces.StudentInterface;

public class Student extends Person implements StudentInterface {
    private String university;
    private Degree degree;

    public Student(String name, int code, int birthYear, String university, Degree degree) {
        super(name, code, birthYear);
        this.university = university;
        this.degree = degree;
        this.applyDiscount();
    }
    @Override
    public String getUniversity() {
        return university;
    }

    @Override
    public Degree getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return super.toString() + " " + getUniversity() + " " + getDegree();
    }

    @Override
    public void applyDiscount() {
        if (this.degree == Degree.LT) {
            this.setTariffa(Archive.TARIFFA_BASE*0.6);
        } else if (this.getBirthYear() < 1968) {
            this.setTariffa(Archive.TARIFFA_BASE*0.65);
        } else if (this.degree == Degree.LM){
            this.setTariffa(Archive.TARIFFA_BASE*0.8);
        } else {
            this.setTariffa(Archive.TARIFFA_BASE);
        }
    }
}
