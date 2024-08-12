package model.people;

import model.Archive;
import model.enums.AthleteRelevance;
import model.interfaces.AthleteInterface;

public class Athlete extends Person implements AthleteInterface {
    private String sport;
    private AthleteRelevance relevance;

    public Athlete(String name, int code, int birthYear, String sport, AthleteRelevance relevance) {
        super(name, code, birthYear);
        this.sport = sport;
        this.relevance = relevance;
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
    public String toString() {
        return super.toString() + " " + getSport() + " " + getRelevance();
    }

    @Override
    public void applyDiscount() {
        if (relevance == AthleteRelevance.Internazionale) {
            this.setTariffa(Archive.TARIFFA_BASE*0.5);
        } else if (this.getBirthYear() < 1968) {
            this.setTariffa(Archive.TARIFFA_BASE*0.65);
        } else if (relevance == AthleteRelevance.Nazionale){
            this.setTariffa(Archive.TARIFFA_BASE*0.7);
        } else {
            this.setTariffa(Archive.TARIFFA_BASE);
        }
    }
}
