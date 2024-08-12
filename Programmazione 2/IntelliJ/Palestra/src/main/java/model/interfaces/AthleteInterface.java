package model.interfaces;

import model.enums.AthleteRelevance;

public interface AthleteInterface extends PersonInterface {
    String getSport();
    AthleteRelevance getRelevance();
}
