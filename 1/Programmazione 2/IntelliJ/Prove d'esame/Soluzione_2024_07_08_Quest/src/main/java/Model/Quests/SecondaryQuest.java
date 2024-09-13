package Model.Quests;

import Model.NPC;
import Model.Quest;

public class SecondaryQuest extends Quest {
    private NPC npc;

    /**
     * imposta l'aumento di livello a 2 invece che 1 come le altre quest
     * @param nome
     * @param livelloMinimo
     * @param ricompensa
     * @param npc
     */
    public SecondaryQuest(String nome, int livelloMinimo, double ricompensa, NPC npc) {
        super(nome, livelloMinimo, ricompensa);
        this.npc = npc;
        setAumentoLivello(2);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNPC: " + npc.getNome();
    }
}
