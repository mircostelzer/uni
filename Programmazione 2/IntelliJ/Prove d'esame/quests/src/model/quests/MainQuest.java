package model.quests;

import model.Geraldo;
import model.enums.Luoghi;
import model.exceptions.PreviousQuestNotCompletedException;

public class MainQuest extends AbstractQuest{

    protected Luoghi luogo;
    protected Quest next;
    protected Quest prec;

    public MainQuest(String no, int lv, Luoghi l, Quest p){
        super(no, lv, 10);
        this.luogo = l;
        this.prec = p;
    }

    @Override
    protected void check_extra_conditions(Geraldo g) throws PreviousQuestNotCompletedException {
        if (this.prec == null){
            return;
        }
        if (! this.prec.is_solved()){
            throw new PreviousQuestNotCompletedException();
        }
    }

    public void setNext(Quest q){
        this.next = q;
    }

    public String getSecondaryInfo(){
        String precs = "none";
        if (this.prec != null){
            precs = this.prec.getName();
        }
        return "Luogo: " + this.luogo+ "\n" +
                "Req. "+precs;
    }
}
