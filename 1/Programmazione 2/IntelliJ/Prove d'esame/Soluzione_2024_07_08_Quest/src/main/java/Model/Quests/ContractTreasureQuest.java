package Model.Quests;

import Model.Mostro;

import java.util.ArrayList;

public class ContractTreasureQuest extends ContractQuest{
    private String luogoTesoro;

    public ContractTreasureQuest(String nome, int livelloMinimo, double ricompensa, ArrayList<Mostro> mostri, String luogoTesoro) {
        super(nome, livelloMinimo, ricompensa, mostri);
        this.luogoTesoro = luogoTesoro;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLuogo: " + luogoTesoro;
    }
}
