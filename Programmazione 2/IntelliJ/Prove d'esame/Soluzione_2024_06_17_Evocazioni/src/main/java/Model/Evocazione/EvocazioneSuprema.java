package Model.Evocazione;

/**
 * La classe EvocazioneSuprema estende la classe Evocazione e rappresenta un tipo speciale di evocazione.
 */
public class EvocazioneSuprema extends Evocazione {

    /**
     * Costruttore per creare una nuova EvocazioneSuprema.
     *
     * @param nome Il nome dell'evocazione suprema.
     * @param pv I punti vita (PV) dell'evocazione suprema.
     * @param tipo Il tipo di energia associata all'evocazione suprema.
     * @param attacco L'attacco dell'evocazione suprema.
     */
    public EvocazioneSuprema(String nome, int pv, Energia tipo, Attacco attacco) {
        super(nome, pv, tipo, attacco);
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'evocazione suprema,
     * aggiungendo "(all)" alla rappresentazione della classe base.
     *
     * @return Una stringa che rappresenta l'evocazione suprema.
     */
    @Override
    public String toString() {
        return super.toString() + " (all)";
    }
}
