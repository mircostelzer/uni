package model.quests;

import model.Geraldo;
import model.exceptions.InsufficientLevelException;
import model.exceptions.PreviousQuestNotCompletedException;

public abstract class AbstractQuest implements Quest{

    protected String name;
    protected int minlv;
    protected int reward;
    protected boolean risolta;

    protected AbstractQuest(String n, int m, int r){
        this.name = n;
        this.minlv = m;
        this.reward = r;
        this.risolta = false;
    }

    protected int getReward(){
        return this.reward;
    }
    public boolean is_solved() {
        return this.risolta;
    }
    public String getName() {
        return name;
    }
    public int getRicompensa() { return this.reward; }

    public boolean is_solvable(Geraldo g){
        return g.getLevel() >= this.minlv;
    }

    protected void addlevel(Geraldo g){
        g.addlevel();
    }

    protected abstract void check_extra_conditions(Geraldo g) throws PreviousQuestNotCompletedException;

    public void solve(Geraldo g) throws PreviousQuestNotCompletedException, InsufficientLevelException{
        if (! is_solvable(g)){
            throw new InsufficientLevelException();
        }
        this.check_extra_conditions(g);

        this.addlevel(g);
        g.addreward( this.getReward() );
        this.risolta = true;
    }

    public String getMainInfo(){
        return this.name+" ("+this.reward+")";
    }
    public abstract String getSecondaryInfo();
}
