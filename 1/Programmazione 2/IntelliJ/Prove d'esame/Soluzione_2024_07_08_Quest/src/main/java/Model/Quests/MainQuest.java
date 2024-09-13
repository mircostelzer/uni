package Model.Quests;

import Model.Quest;

public class MainQuest extends Quest {
    private String luogo;
    private MainQuest precedente;
    private boolean risolta;

    public MainQuest(String nome, int livelloMinimo, String luogo, MainQuest precedente) {
        super(nome, livelloMinimo, 10);
        this.luogo = luogo;
        this.precedente = precedente;
        risolta = false;
    }

    public boolean isRisolta() {
        return risolta;
    }

    public void setRisolta() {
        risolta = true;
    }

    public MainQuest getPrecedente() {
        return precedente;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLuogo: " + luogo +
                "\nReq." + ((precedente == null)? "none" : precedente.getNome());
    }
}
