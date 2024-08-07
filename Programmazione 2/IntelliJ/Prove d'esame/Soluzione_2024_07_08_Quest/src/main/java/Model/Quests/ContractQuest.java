package Model.Quests;

import Model.Mostro;
import Model.Quest;
import java.util.ArrayList;

public class ContractQuest extends Quest {
    private ArrayList<Mostro> mostri;
    private double ricompensaAggiuntiva;

    public ContractQuest(String nome, int livelloMinimo, double ricompensa, ArrayList<Mostro> mostri) {
        super(nome, livelloMinimo, ricompensa);
        this.mostri = new ArrayList<>(mostri);
        ricompensaAggiuntiva = aggiornaRicompensa();
    }

    /**
     * calcola la ricompensa aggiuntiva del 20%
     * @return ricompensa aggiuntiva
     */
    private double aggiornaRicompensa(){
        return getRicompensa()+getRicompensa()*.2;
    }

    public double getRicompensaAggiuntiva() {
        return ricompensaAggiuntiva;
    }

    /**
     *
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nMostri: " + mostri.toString();
    }
}
