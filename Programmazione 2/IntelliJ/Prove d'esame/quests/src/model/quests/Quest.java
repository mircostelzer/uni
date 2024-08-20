package model.quests;

import model.Geraldo;
import model.exceptions.InsufficientLevelException;
import model.exceptions.PreviousQuestNotCompletedException;

public interface Quest {

    void solve(Geraldo g) throws PreviousQuestNotCompletedException, InsufficientLevelException;
    boolean is_solvable(Geraldo g);
    boolean is_solved();
    String getName();
    int getRicompensa();

    String getMainInfo();
    String getSecondaryInfo();
}
