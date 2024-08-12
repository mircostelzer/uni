package model.people;

import model.Archive;
import model.enums.AthleteRelevance;
import model.enums.Degree;
import model.interfaces.AthleteInterface;
import model.interfaces.StudentInterface;

public class AthleteStudent extends Person implements AthleteInterface, StudentInterface {
    private String sport;
    private AthleteRelevance relevance;
    private String university;
    private Degree degree;

    public AthleteStudent(String name, int code, int birthYear, String university, Degree degree, String sport, AthleteRelevance relevance) {
        super(name, code, birthYear);
        this.sport = sport;
        this.relevance = relevance;
        this.university = university;
        this.degree = degree;
        this.applyDiscount();
    }

    @Override
    public String getSport() {
        return sport;
    }

    @Override
    public AthleteRelevance getRelevance() {
        return relevance;
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
        return super.toString() + " " + getUniversity() + " " + getDegree() + " " + getSport() + " " + getRelevance();
    }

    public void applyDiscount() {
        if (this.relevance == AthleteRelevance.Internazionale) {
            this.setTariffa(Archive.TARIFFA_BASE*0.5);
        } else if (this.degree == Degree.LT) {
            this.setTariffa(Archive.TARIFFA_BASE*0.6);
        } else if (this.getBirthYear() < 1968) {
            this.setTariffa(Archive.TARIFFA_BASE*0.65);
        }else if (relevance == AthleteRelevance.Nazionale){
            this.setTariffa(Archive.TARIFFA_BASE*0.7);
        } else if (this.degree == Degree.LM) {

            this.setTariffa(Archive.TARIFFA_BASE*0.8);
        } else {
            this.setTariffa(Archive.TARIFFA_BASE);
        }
    }
}
