package Model.geralt;

/**
 * Enumerazione che rappresenta i diversi tipi di mutazioni che possono essere applicate a Geralt.
 */
public enum Mutation {
    /**
     * Mutazione vuota, utilizzata per indicare l'assenza di una mutazione.
     */
    Empty,

    /**
     * Mutazione di Forza, aumenta la forza di Geralt.
     */
    Str,

    /**
     * Mutazione di Velocità, aumenta la velocità di Geralt.
     */
    Vel,

    /**
     * Mutazione di Tolleranza, aumenta la tolleranza di Geralt alle pozioni.
     */
    Tol,

    /**
     * Mutazione Igni, conferisce a Geralt l'incantesimo Igni.
     */
    Igni,

    /**
     * Mutazione Quen, conferisce a Geralt l'incantesimo Quen.
     */
    Quen
}