package Model.mutations;

/**
 * Interfaccia per rappresentare le operazioni di una mutazione.
 */
public interface MutationInterface {

    /**
     * Applica la mutazione.
     *
     * @throws Exception se l'applicazione della mutazione fallisce.
     */
    void applica() throws Exception;

    /**
     * Rimuove la mutazione.
     */
    void rimuovi();

    /**
     * Restituisce una rappresentazione in stringa della mutazione.
     *
     * @return Stringa che rappresenta la mutazione.
     */
    @Override
    String toString();
}
