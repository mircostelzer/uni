package Model.Evocazione;

/**
 * La classe Attacco rappresenta un attacco con attributi come nome, tipo di energia, energie necessarie e danno.
 */
public class Attacco {
    private String nome;
    private Energia tipo;
    private int energie;
    private int danno;

    /**
     * Costruttore per creare un nuovo attacco.
     *
     * @param nome Il nome dell'attacco.
     * @param tipo Il tipo di energia dell'attacco.
     * @param energie Le energie necessarie per eseguire l'attacco.
     * @param danno Il danno inflitto dall'attacco.
     */
    public Attacco(String nome, Energia tipo, int energie, int danno) {
        this.nome = nome;
        this.tipo = tipo;
        this.energie = energie;
        this.danno = danno;
    }

    /**
     * Restituisce le energie necessarie per eseguire l'attacco.
     *
     * @return Le energie necessarie.
     */
    public int getEnergie() {
        return energie;
    }

    /**
     * Calcola e restituisce il danno inflitto dall'attacco in base al tipo di energia dell'opponente.
     * Se l'attacco è di tipo acqua e l'opponente è di tipo fuoco, o viceversa, o l'attacco è di tipo tenebra, il danno è raddoppiato.
     *
     * @param oppo Il tipo di energia dell'opponente.
     * @return Il danno inflitto.
     */
    public int getDanno(Energia oppo) {
        if ((tipo.equals(Energia.ACQUA) && oppo.equals(Energia.FUOCO)) ||
                (tipo.equals(Energia.FUOCO) && oppo.equals(Energia.ACQUA)) ||
                (tipo.equals(Energia.TENEBRA))) {
            return danno * 2;
        }
        return danno;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'attacco.
     *
     * @return Una stringa che rappresenta l'attacco.
     */
    @Override
    public String toString() {
        return nome + "(" + energie + ")\n" +
                danno + " danni";
    }
}
