package Model.Evocazione;

/**
 * La classe Evocazione rappresenta un'entità evocata con attributi come nome, punti vita (PV), tipo di energia, attacco e altri stati.
 */
public class Evocazione {
    private String nome;
    private int pv;
    private Energia tipo;
    private Attacco attacco;
    private int pvAttuali;
    private int energieAssegnate;
    private boolean attacking;

    /**
     * Costruttore per creare una nuova evocazione.
     *
     * @param nome Il nome dell'evocazione.
     * @param pv I punti vita (PV) dell'evocazione.
     * @param tipo Il tipo di energia associata all'evocazione.
     * @param attacco L'attacco dell'evocazione.
     */
    public Evocazione(String nome, int pv, Energia tipo, Attacco attacco) {
        this.nome = nome;
        this.pv = pv;
        this.tipo = tipo;
        this.attacco = attacco;
        pvAttuali = pv;
        energieAssegnate = 0;
        attacking = false;
    }

    /**
     * Riduce le energie assegnate all'evocazione in base alle energie richieste dall'attacco.
     */
    public void setEnergieAssegnate() {
        energieAssegnate -= attacco.getEnergie();
    }

    /**
     * Restituisce l'attacco dell'evocazione.
     *
     * @return L'attacco dell'evocazione.
     */
    public Attacco getAttacco() {
        return attacco;
    }

    /**
     * Restituisce i punti vita attuali dell'evocazione.
     *
     * @return I punti vita attuali.
     */
    public int getPvAttuali() {
        return pvAttuali;
    }

    /**
     * Restituisce le energie assegnate all'evocazione.
     *
     * @return Le energie assegnate.
     */
    public int getEnergieAssegnate() {
        return energieAssegnate;
    }

    /**
     * Verifica se l'evocazione sta attaccando.
     *
     * @return true se l'evocazione sta attaccando, altrimenti false.
     */
    public boolean isAttacking() {
        return attacking;
    }

    /**
     * Imposta lo stato di attacco dell'evocazione.
     *
     * @param attacking true per impostare l'evocazione in stato di attacco, altrimenti false.
     */
    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    /**
     * Riduce i punti vita attuali dell'evocazione in base al danno ricevuto.
     *
     * @param danno Il danno ricevuto dall'evocazione.
     */
    public void riceviAttacco(int danno) {
        pvAttuali -= danno;
    }

    /**
     * Restituisce il tipo di energia dell'evocazione.
     *
     * @return Il tipo di energia.
     */
    public Energia getTipo() {
        return tipo;
    }

    /**
     * Incrementa di una unità le energie assegnate all'evocazione.
     */
    public void incrementaEnergieAssegnate() {
        energieAssegnate++;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'evocazione.
     *
     * @return Una stringa che rappresenta l'evocazione.
     */
    @Override
    public String toString() {
        return  nome + "\n" +
                pvAttuali + "/" + pv + "\n" +
                "Energie: " + energieAssegnate + "\n" +
                attacco.toString();
    }
}
